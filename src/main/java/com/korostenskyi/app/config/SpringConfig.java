package com.korostenskyi.app.config;

import com.korostenskyi.app.data.network.NetworkDataSource;
import com.korostenskyi.app.data.network.NetworkDataSourceImpl;
import com.korostenskyi.app.service.concurrent.ConcurrentTaskService;
import com.korostenskyi.app.service.concurrent.ConcurrentTaskServiceImpl;
import com.korostenskyi.app.service.generator.NumberGenerator;
import com.korostenskyi.app.service.generator.NumberGeneratorImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.korostenskyi.app")
public class SpringConfig {

    @Bean
    public NetworkDataSource networkDataSource() {
        return new NetworkDataSourceImpl();
    }

    @Bean
    public NumberGenerator numberGenerator() {
        return new NumberGeneratorImpl();
    }

    @Bean
    public ConcurrentTaskService taskService() {
        return new ConcurrentTaskServiceImpl(networkDataSource());
    }
}
