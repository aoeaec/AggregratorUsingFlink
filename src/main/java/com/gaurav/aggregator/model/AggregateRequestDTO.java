package com.gaurav.aggregator.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;

@Getter
@RequiredArgsConstructor
@Setter
public class AggregateRequestDTO {

    @Valid
    private Integer period;
}
