package com.WriteArticle.springProject.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    /*
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

     */

    @Bean
    public ModelMapper getModelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);//birebir örtüşen alanları eşleştirmeye yarar
        return modelMapper;
    }

}
