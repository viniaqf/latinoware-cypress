package com.example.latinoware.service;

import com.example.latinoware.dto.OratorDTO;
import com.example.latinoware.entity.Orator;
import com.example.latinoware.repository.OratorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class OratorService {
    @Autowired
    private OratorRepository repository;
    private final ModelMapper modelMapper = new ModelMapper();

    public Orator toOratorEnt(OratorDTO oratorDTO){
        return modelMapper.map(oratorDTO, Orator.class);
    }
    public OratorDTO toOratorDTO(Orator oratorEnt){
        return modelMapper.map(oratorEnt, OratorDTO.class);
    }
    public OratorDTO post(OratorDTO orator){
        Assert.hasText(orator.getAge(), "Por favor, coloque uma idade válida!");
        Assert.notNull(orator.getCompanyName(), "Por favor, insira a empresa do Orador.");
        Assert.notNull(orator.getJobTitle(), "Por favor, insira a titulação do Orador");
        Assert.hasText(orator.getJobTitle(), "Por favor, insira uma titulação válida!.");
        return toOratorDTO(repository.save(toOratorEnt(orator)));
    }



}
