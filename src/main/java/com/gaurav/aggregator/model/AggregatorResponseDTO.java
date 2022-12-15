package com.gaurav.aggregator.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AggregatorResponseDTO {


    @JsonProperty("660")
    private Metric assetId = new Metric();

}
