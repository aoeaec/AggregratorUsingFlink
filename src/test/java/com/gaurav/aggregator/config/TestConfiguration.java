package com.gaurav.aggregator.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({
        "com.gaurav.aggregator.service",
        "com.gaurav.aggregator.config",
        "com.gaurav.aggregator.repository",
        "com.gaurav.aggregator.web.controller",
        "com.gaurav.aggregator.engine",
        "com.gaurav.aggregator.engine.flink",
        "com.gaurav.aggregator.common",
        "com.gaurav.aggregator.web.advice"

})
public class TestConfiguration {

}