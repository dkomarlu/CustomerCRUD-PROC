package com.mycompany.apexdemo.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ApexConfig {

    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }


}
