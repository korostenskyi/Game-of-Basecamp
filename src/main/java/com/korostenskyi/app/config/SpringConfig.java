package com.korostenskyi.app.config;

import com.korostenskyi.app.data.network.NetworkDataSource;
import com.korostenskyi.app.data.network.NetworkDataSourceImpl;
import com.korostenskyi.app.service.concurrent.ConcurrentTaskService;
import com.korostenskyi.app.service.concurrent.ConcurrentTaskServiceImpl;
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
    public ConcurrentTaskService taskService() {
        return new ConcurrentTaskServiceImpl(networkDataSource());
    }
}
