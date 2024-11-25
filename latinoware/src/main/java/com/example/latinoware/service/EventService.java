package com.example.latinoware.service;

import com.example.latinoware.dto.EventDTO;
import com.example.latinoware.entity.Event;
import com.example.latinoware.entity.Orator;
import com.example.latinoware.repository.EventRepository;
import com.example.latinoware.repository.OratorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class EventService {
    @Autowired
    private EventRepository repository;
    @Autowired
    private OratorRepository oratorRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public Event toEventEnt(EventDTO eventDTO){
        return modelMapper.map(eventDTO, Event.class);
    }

    public EventDTO toEventDTO(Event eventEnt){
        return modelMapper.map(eventEnt, EventDTO.class);
    }

    public List<Event> toEventEntityList(List<EventDTO> eventDTOs) {
        return eventDTOs.stream()
                .map(dto -> modelMapper.map(dto, Event.class))
                .collect(Collectors.toList());
    }

    public Map<String, List<?>> createMultipleEvents(List<EventDTO> eventDTOs) {
        Set<String> existingEventNames = repository.findAll().stream().map(Event::getName).collect(Collectors.toSet());

        List<Event> validEvents = new ArrayList<>();
        List<String> errorMessages = new ArrayList<>();
        for (EventDTO eventDTO : eventDTOs){
            if (existingEventNames.contains(eventDTO.getName())){
                errorMessages.add("Já existe um evento com o nome " + eventDTO.getName());
            } else {
                validEvents.add(modelMapper.map(eventDTO, Event.class));
            }
        }

        List<Event> savedEvents = repository.saveAll(validEvents);
        List<EventDTO> savedEventsDTOs = savedEvents.stream().map(this::toEventDTO).toList();

        Map<String, List<?>> response = new HashMap<>();
        response.put("savedEvents", savedEventsDTOs);
        response.put("errors", errorMessages);

        return response;
    }

    public EventDTO post(EventDTO event){

        Optional<Event> existingEvent = repository.findByName(event.getName());

        if (existingEvent.isPresent()){
            throw new IllegalArgumentException("Já existe um evento com o nome " + event.getName());
        }
        Orator oratorDB = oratorRepository.findById(event.getOrator().getId()).orElse(null);
        Assert.notNull(event.getName(),"Por favor, insira o nome do evento.");
        Assert.hasText(event.getName(), "Digite um nome válido.");
        Assert.notNull(event.getDate(), "Por favor, insira a data do evento.");
        Assert.notNull(event.getLocation(), "Por favor, insira a localização do evento.");
        Assert.notNull(oratorDB, "O Orador informado não está cadastrado.");
        return toEventDTO(repository.save(toEventEnt(event)));
    }
    public EventDTO put(EventDTO event, Long id){
        Orator oratorDB = oratorRepository.findById(event.getOrator().getId()).orElse(null);
        Assert.notNull(id, "Por favor, insira um ID.");
        Assert.notNull(event.getId(), "Por favor, insira um ID.");
        Assert.notNull(event.getName(),"Por favor, insira o nome do evento.");
        Assert.hasText(event.getName(), "Digite um nome válido.");
        Assert.notNull(event.getDate(), "Por favor, insira a data do evento.");
        Assert.notNull(event.getLocation(), "Por favor, insira a localização do evento.");
        Assert.notNull(oratorDB, "O Orador informado não está cadastrado.");
        event.update();
        return toEventDTO(repository.save(toEventEnt(event)));
    }

    public EventDTO findById(Long id) {
        Event event = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Evento com ID " + id + " não encontrado."));
        return toEventDTO(event);
    }

    public List<EventDTO> getAll(){
        return repository.findAll().stream().map(this::toEventDTO).toList();
    }

    public List<EventDTO> findAllActive(){
        return repository.findByActiveTrue().stream().map(this::toEventDTO).toList();
    }

    public EventDTO disable (Long id ){
        EventDTO eventDTO = findById(id);
        eventDTO.disable();
        eventDTO.setActive(false);
        return toEventDTO(repository.save(toEventEnt(eventDTO)));
    }

    public EventDTO enable (Long id){
        EventDTO eventDTO = findById(id);
        eventDTO.enable();
        eventDTO.setActive(true);
        return toEventDTO(repository.save(toEventEnt(eventDTO)));
    }

    public void deleteEventReal (Long id){
        Event event = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Evento com ID " + id + " não encontrado."));
        repository.delete(event);
    }

    public void deleteAll(){
        repository.deleteAll();
    }

}
