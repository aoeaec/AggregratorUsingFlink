package com.gaurav.aggregator.engine.flink;

import com.gaurav.aggregator.model.FetchedData;

import java.util.ArrayList;
import java.util.List;

public class CustomSinkFunction implements org.apache.flink.streaming.api.functions.sink.SinkFunction<FetchedData> {

    public static List<FetchedData> fetchedDataList = new ArrayList<>();

    @Override
    public void invoke(FetchedData fetchedData) throws Exception {
        fetchedDataList.add(fetchedData);
    }
}