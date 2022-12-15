package com.gaurav.aggregator.engine;

import com.gaurav.aggregator.model.AggregatedResultForFlink;

public interface AggregateEngine {

    public AggregatedResultForFlink aggregate(int minutes) throws Exception;
}
