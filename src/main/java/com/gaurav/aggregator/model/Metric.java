package com.gaurav.aggregator.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Metric {
    @JsonProperty("3000")
    private List<Double> code_3000 = new ArrayList<>();
    @JsonProperty("3001")
    private List<Double> code_3001 = new ArrayList<>();
    @JsonProperty("3002")
    private List<Double> code_3002 = new ArrayList<>();
    @JsonProperty("3003")
    private List<Double> code_3003 = new ArrayList<>();
    @JsonProperty("3004")
    private List<Double> code_3004 = new ArrayList<>();

    @JsonProperty("3005")
    private List<Double> code_3005 = new ArrayList<>();
    @JsonProperty("time")
    private List<Date> time = new ArrayList<>();

}
