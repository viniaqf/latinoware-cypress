package com.example.latinoware.controller;

import com.example.latinoware.dto.OratorDTO;
import com.example.latinoware.service.OratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/orator")
public class OratorController {
    @Autowired
    OratorService service;

    @GetMapping("/id/{id}")
    public ResponseEntity<OratorDTO>findById(@PathVariable("id") final long id){
        return ResponseEntity.ok(service.findById(id));
    }
    @GetMapping("/all")
    public ResponseEntity<List<OratorDTO>>getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/all-actives")
    public ResponseEntity<List<OratorDTO>>findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping("/post")
    public ResponseEntity<?>post(@RequestBody OratorDTO oratorDTO){
        try{
            this.service.post(oratorDTO);
            return ResponseEntity.ok("Orador cadastrado com sucesso!");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PutMapping("/put/{id}")
    public ResponseEntity<?>put(@RequestBody OratorDTO oratorDTO, @PathVariable("id") final long id){
        try{
            OratorDTO oratorName = service.findById(id);
            this.service.put(oratorDTO,id);
            return ResponseEntity.ok( "Palestrante " + oratorName.getName() + " atualizado com sucesso!");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @DeleteMapping("/disable/{id}")
    public ResponseEntity<?>disable(@PathVariable("id") final long id){
        try {
            OratorDTO oratorName = service.findById(id);
            this.service.disable(id);
            return ResponseEntity.ok("Palestrante " + oratorName.getName() + " desativado com sucesso!");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PutMapping("/enable/{id}")
    public ResponseEntity<?>enable(@PathVariable("id") final long id){
        try{
            OratorDTO oratorName = service.findById(id);
            this.service.enable(id);
            return ResponseEntity.ok( "Palestrante " + oratorName.getName() + " ativado com sucesso!");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
