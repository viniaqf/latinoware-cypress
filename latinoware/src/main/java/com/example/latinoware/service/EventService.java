package com.example.latinoware.service;

import com.example.latinoware.dto.EventDTO;
import com.example.latinoware.entity.Event;
import com.example.latinoware.repository.EventRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;


@Service
public class EventService {
    @Autowired
    private EventRepository repository;
    private final ModelMapper modelMapper = new ModelMapper();

    public Event toEventEnt(EventDTO eventDTO){
        return modelMapper.map(eventDTO, Event.class);
    }

    public EventDTO toEventDTO(Event eventEnt){
        return modelMapper.map(eventEnt, EventDTO.class);
    }
    public EventDTO post(EventDTO event){
        Assert.notNull(event.getName(),"Por favor, insira o nome do evento.");
        Assert.hasText(event.getName(), "Digite um nome válido.");
        Assert.notNull(event.getDate(), "Por favor, insira a data do evento.");
        Assert.notNull(event.getLocation(), "Por favor, insira a localização do evento.");
        Assert.notNull(event.getOrator(), "Por favor, insira o Orador que irá conduzir o evento.");
        return toEventDTO(repository.save(toEventEnt(event)));
    }
    public EventDTO put(EventDTO event, Long id){
        Assert.notNull(id, "Por favor, insira um ID.");
        Assert.notNull(event.getId(), "Por favor, insira um ID.");
        Assert.notNull(event.getName(),"Por favor, insira o nome do evento.");
        Assert.hasText(event.getName(), "Digite um nome válido.");
        Assert.notNull(event.getDate(), "Por favor, insira a data do evento.");
        Assert.notNull(event.getLocation(), "Por favor, insira a localização do evento.");
        Assert.notNull(event.getOrator(), "Por favor, insira o Orador que irá conduzir o evento.");
        return toEventDTO(repository.save(toEventEnt(event)));
    }

    public EventDTO findById(Long id) {
        Event event = repository.findById(id).orElse(null);
        return toEventDTO(event);
    }

    public List<EventDTO> getAll(){
        return repository.findAll().stream().map(this::toEventDTO).toList();
    }

    public EventDTO disable (Long id ){
        EventDTO eventDTO = findById(id);
        eventDTO.disable();
        return toEventDTO(repository.save(toEventEnt(eventDTO)));
    }

    public EventDTO enable (Long id){
        EventDTO eventDTO = findById(id);
        eventDTO.enable();
        return toEventDTO(repository.save(toEventEnt(eventDTO)));
    }
}
