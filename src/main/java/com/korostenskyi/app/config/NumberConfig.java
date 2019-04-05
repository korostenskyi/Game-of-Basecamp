package com.korostenskyi.app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.korostenskyi.app")
@PropertySource("classpath:settings.properties")
public class NumberConfig {

    @Value("${number.minValue}")
    private Long minValue;

    @Value("${number.maxValue}")
    private Long maxValue;

    @Bean("minValue")
    public Long getMinValue() {
        return minValue;
    }

    @Bean("maxValue")
    public Long getMaxValue() {
        return maxValue;
    }
}
