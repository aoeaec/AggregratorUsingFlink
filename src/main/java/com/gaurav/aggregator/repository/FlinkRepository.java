package com.gaurav.aggregator.repository;

import com.gaurav.aggregator.model.DataProviderResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

@Repository
public class FlinkRepository {

    @Autowired
    WebClient webClient;

    public DataProviderResult getDataProviderResult(){
        WebClient.ResponseSpec responseSpec = webClient.get().retrieve();
        return responseSpec.bodyToMono(DataProviderResult.class).block();
    }

}
