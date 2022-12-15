package com.gaurav.aggregator.engine.flink;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gaurav.aggregator.engine.AggregateEngine;
import com.gaurav.aggregator.exception.AggregatorException;
import com.gaurav.aggregator.model.AggregatedResultForFlink;
import com.gaurav.aggregator.model.DataProviderResult;
import com.gaurav.aggregator.model.FetchedData;
import com.gaurav.aggregator.model.Metric;
import com.gaurav.aggregator.repository.FlinkRepository;
import org.apache.flink.streaming.api.TimeCharacteristic;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.assigners.TumblingEventTimeWindows;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FlinkEngine implements AggregateEngine {

    final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    FlinkRepository repository;

    private static FetchedData deriveAverage(FetchedData a, FetchedData b) {
        try {
            return new FetchedData((a.getCode_3000() + b.getCode_3000()) / 2, (a.getCode_3001() + b.getCode_3001()) / 2,
                    (a.getCode_3002() + b.getCode_3002()) / 2, (a.getCode_3003() + b.getCode_3003()) / 2,
                    (a.getCode_3004() + b.getCode_3004()) / 2, (a.getCode_3005() + b.getCode_3005()) / 2, a.getTime());
        } catch (Exception e) {
            throw new AggregatorException("Unable to derive average ::" + e);
        }
    }

    @Override
    public AggregatedResultForFlink aggregate(int minutes) {
        env.setStreamTimeCharacteristic(TimeCharacteristic.EventTime);
        DataProviderResult dataProviderResult = repository.getDataProviderResult();

        List<FetchedData> fetchedDataList = createFetchedDataListFromDataProviderResult(dataProviderResult);

        DataStream<FetchedData> fetchedDataStream = env.fromCollection(fetchedDataList);
        fetchedDataStream.assignTimestampsAndWatermarks(new CustomTimestampsAndWatermarks()).keyBy(FetchedData::getTest).window(TumblingEventTimeWindows.of(Time.minutes(minutes)))
                .reduce(FlinkEngine::deriveAverage)
                .addSink(new CustomSinkFunction());

        try {
            env.execute();
        } catch (Exception e) {
            throw new AggregatorException("Unable to execute flink " + e.getStackTrace());
        }
        AggregatedResultForFlink aggregatedResultForFlink = new AggregatedResultForFlink();
        aggregatedResultForFlink.setAggregatedData(List.copyOf(CustomSinkFunction.fetchedDataList));
        CustomSinkFunction.fetchedDataList.clear();
        return aggregatedResultForFlink;
    }

    private List<FetchedData> createFetchedDataListFromDataProviderResult(DataProviderResult dataProviderResult) {
        List<FetchedData> fetchedDataList = new ArrayList<>();

        Metric metric = dataProviderResult.getAssetId();
        for (int i = 0; i < dataProviderResult.getAssetId().getCode_3000().size(); i++) {
            fetchedDataList.add(new FetchedData(metric.getCode_3000().get(i), metric.getCode_3001().get(i), metric.getCode_3002().get(i), metric.getCode_3003().get(i), metric.getCode_3004().get(i), metric.getCode_3005().get(i), metric.getTime().get(i)));
        }

        return fetchedDataList;
    }


}
