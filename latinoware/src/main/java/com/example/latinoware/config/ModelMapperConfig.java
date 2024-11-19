package com.example.latinoware.config;

import com.example.latinoware.dto.AbstractEntityDTO;
import com.example.latinoware.entity.AbstractEntity;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapperOrator() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.typeMap(AbstractEntityDTO.class, AbstractEntity.class)
                .addMapping(AbstractEntityDTO::getId, AbstractEntity::setId);
        return modelMapper;
    }

}

