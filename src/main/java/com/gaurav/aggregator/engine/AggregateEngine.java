package com.gaurav.aggregator.engine;

import com.gaurav.aggregator.model.AggregatedResult;

public interface AggregateEngine {

    public AggregatedResult aggregate(int minutes) throws Exception;
}
