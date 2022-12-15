package com.gaurav.aggregator.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class DataProviderResult {

    @JsonProperty("660")
    private Metric assetId;

}
