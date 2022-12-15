package com.gaurav.aggregator.service;

import com.gaurav.aggregator.engine.AggregateEngine;
import com.gaurav.aggregator.model.AggregatorResponseDTO;
import com.gaurav.aggregator.model.AggregatedResult;
import com.gaurav.aggregator.model.FetchedData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AggregateService {

    @Autowired
    AggregateEngine flinkEngine;
    public AggregatorResponseDTO aggregate(int minutes){

        AggregatedResult aggregatedResult = null;
        AggregatorResponseDTO responseDTO = new AggregatorResponseDTO();
        try {

            aggregatedResult = flinkEngine.aggregate(minutes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        for(FetchedData result : aggregatedResult.getAggregatedData()){
            responseDTO.getAssetId().getCode_3000().add(result.getCode_3000());
            responseDTO.getAssetId().getCode_3001().add(result.getCode_3001());
            responseDTO.getAssetId().getCode_3002().add(result.getCode_3002());
            responseDTO.getAssetId().getCode_3003().add(result.getCode_3003());
            responseDTO.getAssetId().getCode_3004().add(result.getCode_3004());
            responseDTO.getAssetId().getCode_3005().add(result.getCode_3005());
            responseDTO.getAssetId().getTime().add(result.getTime());
        }

        return responseDTO;
    }
}
