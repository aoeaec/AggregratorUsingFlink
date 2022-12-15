package com.gaurav.aggregator.engine.flink;

import com.gaurav.aggregator.model.FetchedData;
import org.apache.flink.streaming.api.functions.AssignerWithPeriodicWatermarks;
import org.apache.flink.streaming.api.watermark.Watermark;

public class CustomTimestampsAndWatermarks implements AssignerWithPeriodicWatermarks<FetchedData> {
    private long currentMaxTimestamp;

    @Override
    public Watermark getCurrentWatermark() {
        return new Watermark(currentMaxTimestamp - 1L);
    }


    @Override
    public long extractTimestamp(FetchedData fetchedData, long l) {
        long timestamp = fetchedData.time.getTime();

        currentMaxTimestamp = timestamp;
         return timestamp;
    }
}