package com.gaurav.aggregator.engine;

public interface AggregateEngine<T> {

    <T> T performAggregate(int minutes);
}
