package com.gaurav.aggregator.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@RequiredArgsConstructor
@Setter
public class AggregateRequestDTO {

    private int period;
}