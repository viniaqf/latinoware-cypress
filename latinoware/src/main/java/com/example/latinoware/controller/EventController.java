package com.example.latinoware.controller;

import com.example.latinoware.dto.EventDTO;
import com.example.latinoware.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "/api/event")
public class EventController {
    @Autowired
    EventService service;

    @GetMapping("/id/{id}")
    public ResponseEntity<EventDTO>findById(@PathVariable("id") final long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<EventDTO>>getAll(){
        return ResponseEntity.ok(service.getAll());
    }
    @GetMapping("/all-actives")
    public ResponseEntity<List<EventDTO>>findAll(){
        return ResponseEntity.ok(service.findAllActive());
    }

    @PostMapping("/multiples")
    public List<?> createMultipleEvents(@RequestBody List<EventDTO> events){
        try {
            List<EventDTO> createdEvents = service.createMultipleEvents(events);
            return ResponseEntity.ok(createdEvents).getBody();
        } catch (Exception e){
            return Collections.singletonList(ResponseEntity.badRequest().body(e.getMessage()));
        }
    }

    @PostMapping("/post")
    public ResponseEntity<?>post(@RequestBody @Validated EventDTO eventDTO){
        try{
            this.service.post(eventDTO);
            return ResponseEntity.ok("Evento criado com sucesso!");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PutMapping("/put/{id}")
    public ResponseEntity<?>put(@RequestBody @Validated EventDTO eventDTO, @PathVariable("id") final long id){
        try {
            EventDTO eventName = service.findById(id);
            this.service.put(eventDTO,id);
            return ResponseEntity.ok("Evento "+ eventName.getName() +" atualizado com sucesso!");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @DeleteMapping("/disable/{id}")
    public ResponseEntity<?>disable(@PathVariable("id") final long id){
        try{
            EventDTO eventName = service.findById(id);
            this.service.disable(id);
            return ResponseEntity.ok("Evento "+ eventName.getName() +" desativado com sucesso!");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PutMapping("/enable/{id}")
    public ResponseEntity<?>enable(@PathVariable("id") final long id){
        try{
            EventDTO eventName = service.findById(id);
            this.service.enable(id);
            return ResponseEntity.ok("Evento "+ eventName.getName() +" ativado com sucesso!");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
