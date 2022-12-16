package com.gaurav.aggregator.service;

import com.gaurav.aggregator.config.TestConfiguration;
import com.gaurav.aggregator.engine.flink.FlinkEngine;
import com.gaurav.aggregator.model.AggregatedResultForFlink;
import com.gaurav.aggregator.model.AggregatorResponseDTO;
import com.gaurav.aggregator.model.FetchedData;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {TestConfiguration.class})
class AggregateServiceTest {

    @MockBean
    FlinkEngine flinkEngine;

    @Autowired
    AggregateService aggregateService;


    @SneakyThrows
    @Test
    public void aggregate() {
        List<FetchedData> fetchedDataList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            fetchedDataList.add(Mockito.mock(FetchedData.class));
        }
        AggregatedResultForFlink aggregatedResultForFlink = new AggregatedResultForFlink();
        aggregatedResultForFlink.setAggregatedData(fetchedDataList);
        when(flinkEngine.performAggregate(4)).thenReturn(aggregatedResultForFlink);
        AggregatorResponseDTO aggregate = aggregateService.aggregate(4);
        Assert.assertEquals(aggregate.getAssetId().getCode_3000().size(), fetchedDataList.size());
        Assert.assertEquals(aggregate.getAssetId().getCode_3001().size(), fetchedDataList.size());
        Assert.assertEquals(aggregate.getAssetId().getCode_3002().size(), fetchedDataList.size());
        Assert.assertEquals(aggregate.getAssetId().getCode_3003().size(), fetchedDataList.size());
        Assert.assertEquals(aggregate.getAssetId().getCode_3004().size(), fetchedDataList.size());
        Assert.assertEquals(aggregate.getAssetId().getCode_3005().size(), fetchedDataList.size());
    }


}