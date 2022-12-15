package com.gaurav.aggregator.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class AggregatedResultForFlink {


    private List<FetchedData> aggregatedData = new ArrayList<>();
}
