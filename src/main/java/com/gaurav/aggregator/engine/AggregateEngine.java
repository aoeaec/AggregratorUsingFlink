package com.gaurav.aggregator.engine;

import com.gaurav.aggregator.model.AggregatedResultForFlink;

public interface AggregateEngine {

    AggregatedResultForFlink aggregate(int minutes);
}
