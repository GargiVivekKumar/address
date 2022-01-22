package com.example.address.config;

import com.example.address.dto.AddressDTO;
import com.example.address.model.Address;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelmapper = new ModelMapper();
        modelmapper.createTypeMap(Address.class, AddressDTO.class);
        return modelmapper;
    }
}
