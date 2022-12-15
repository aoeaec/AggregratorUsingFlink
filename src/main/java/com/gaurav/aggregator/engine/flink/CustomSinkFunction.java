package com.gaurav.aggregator.engine.flink;

import com.gaurav.aggregator.model.FetchedData;
import org.apache.flink.streaming.api.functions.sink.SinkFunction;

import java.util.ArrayList;
import java.util.List;

public class CustomSinkFunction implements SinkFunction<FetchedData> {

    public static List<FetchedData> fetchedDataList = new ArrayList<>();

    @Override
    public void invoke(FetchedData fetchedData) {
        fetchedDataList.add(fetchedData);
    }
}