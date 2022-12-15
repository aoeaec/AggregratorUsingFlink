package com.gaurav.aggregator.web.controller;

import com.gaurav.aggregator.model.AggregateRequestDTO;
import com.gaurav.aggregator.model.AggregatorResponseDTO;
import com.gaurav.aggregator.service.AggregateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AggregatorController {

    @Autowired
    private AggregateService aggregateService;

    @PostMapping(path = "/aggregate")
    public AggregatorResponseDTO getAggregate(@RequestBody AggregateRequestDTO requestDTO){

        return aggregateService.aggregate(requestDTO.getPeriod());
    }

}
