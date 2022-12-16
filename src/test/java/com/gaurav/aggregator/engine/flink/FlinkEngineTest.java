package com.gaurav.aggregator.engine.flink;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gaurav.aggregator.config.TestConfiguration;
import com.gaurav.aggregator.model.AggregatedResultForFlink;
import com.gaurav.aggregator.model.DataProviderResult;
import com.gaurav.aggregator.repository.FlinkRepository;
import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.nio.charset.StandardCharsets;
import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {TestConfiguration.class})
class FlinkEngineTest {

    @Autowired
    FlinkEngine flinkEngine;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    FlinkRepository repository;

    @SneakyThrows
    @Test
    void performAggregate() {

        DataProviderResult result = objectMapper.readValue(IOUtils.resourceToString("mockResponse.json", StandardCharsets.UTF_8, this.getClass().getClassLoader()), DataProviderResult.class);

        when(repository.getDataProviderResult()).thenReturn(result);
        AggregatedResultForFlink aggregatedResultForFlink = flinkEngine.performAggregate(2);
        assertEquals(4, aggregatedResultForFlink.getAggregatedData().size());
        assertEquals(4.908937492180376,aggregatedResultForFlink.getAggregatedData().get(0).getCode_3000() );
        assertEquals(4.408937492180376,aggregatedResultForFlink.getAggregatedData().get(0).getCode_3001() );
        assertEquals(4.408937492180376,aggregatedResultForFlink.getAggregatedData().get(0).getCode_3002() );
        assertEquals(4.408937492180376,aggregatedResultForFlink.getAggregatedData().get(0).getCode_3003() );
        assertEquals(4.408937492180376,aggregatedResultForFlink.getAggregatedData().get(0).getCode_3004() );
        assertEquals(4.392300000000001,aggregatedResultForFlink.getAggregatedData().get(0).getCode_3005() );
        assertEquals(4, aggregatedResultForFlink.getAggregatedData().size());
        assertEquals("Wed Dec 14 15:00:00 AEDT 2022",aggregatedResultForFlink.getAggregatedData().get(0).getTime().toString() );
        assertEquals("Wed Dec 14 15:02:00 AEDT 2022",aggregatedResultForFlink.getAggregatedData().get(1).getTime().toString() );
        assertEquals("Wed Dec 14 15:04:00 AEDT 2022",aggregatedResultForFlink.getAggregatedData().get(2).getTime().toString() );
        assertEquals("Wed Dec 14 15:06:00 AEDT 2022",aggregatedResultForFlink.getAggregatedData().get(3).getTime().toString() );
    }
}