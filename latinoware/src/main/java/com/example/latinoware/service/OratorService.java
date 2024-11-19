package com.example.latinoware.service;

import com.example.latinoware.dto.OratorDTO;
import com.example.latinoware.entity.Orator;
import com.example.latinoware.repository.OratorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.List;

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
        Assert.notNull(orator.getCompanyName(), "Por favor, insira a empresa do Orador.");
        Assert.notNull(orator.getJobTitle(), "Por favor, insira a titulação do Orador");
        Assert.hasText(orator.getJobTitle(), "Por favor, insira uma titulação válida!.");
        return toOratorDTO(repository.save(toOratorEnt(orator)));
    }
    public OratorDTO put(OratorDTO oratorDTO, Long id){
        Assert.notNull(id, "Por favor, insira um ID.");
        Assert.notNull(oratorDTO.getCompanyName(), "Por favor, insira a empresa do Orador.");
        Assert.notNull(oratorDTO.getJobTitle(), "Por favor, insira a titulação do Orador");
        Assert.hasText(oratorDTO.getJobTitle(), "Por favor, insira uma titulação válida!.");
        return toOratorDTO(repository.save(toOratorEnt(oratorDTO)));
    }

    public OratorDTO findById(Long id) {
        Orator orator = repository.findById(id).orElse(null);
        return toOratorDTO(orator);
    }

    public List<OratorDTO> getAll(){
        return repository.findAll().stream().map(this::toOratorDTO).toList();
    }

    public OratorDTO disable (Long id ){
        OratorDTO oratorDTO = findById(id);
        oratorDTO.disable();
        oratorDTO.setDeleted(LocalDateTime.now());
        return toOratorDTO(repository.save(toOratorEnt(oratorDTO)));
    }

    public OratorDTO enable (Long id){
        OratorDTO oratorDTO = findById(id);
        oratorDTO.enable();
        return toOratorDTO(repository.save(toOratorEnt(oratorDTO)));
    }
   


}
