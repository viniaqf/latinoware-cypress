package com.example.latinoware.controller;

import com.example.latinoware.dto.EventDTO;
import com.example.latinoware.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
            this.service.put(eventDTO,id);
            return ResponseEntity.ok("Atualizado com sucesso!");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @DeleteMapping("/disable/{id}")
    public ResponseEntity<?>disable(@PathVariable("id") final long id){
        try{
            this.service.disable(id);
            return ResponseEntity.ok("Desativado com sucesso!");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PutMapping("/enable/{id}")
    public ResponseEntity<?>enable(@PathVariable("id") final long id){
        try{
            this.service.enable(id);
            return ResponseEntity.ok("Ativado com sucesso!");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
