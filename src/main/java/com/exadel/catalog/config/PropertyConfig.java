package com.exadel.catalog.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.env.Environment;

@Configuration
public class PropertyConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
