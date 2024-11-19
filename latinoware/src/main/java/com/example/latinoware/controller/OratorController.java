package com.example.latinoware.controller;

import com.example.latinoware.dto.OratorDTO;
import com.example.latinoware.service.OratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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

    @GetMapping("/todos")
    public ResponseEntity<List<OratorDTO>>findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping("/post")
    public ResponseEntity<?>post(@RequestBody @Validated OratorDTO oratorDTO){
        try{
            this.service.post(oratorDTO);
            return ResponseEntity.ok("Orador cadastrado com sucesso!");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PutMapping("/put/{id}")
    public ResponseEntity<?>put(@RequestBody @Validated OratorDTO oratorDTO, @PathVariable("id") final long id){
        try{
            this.service.put(oratorDTO,id);
            return ResponseEntity.ok("Atualizado com sucesso!");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @DeleteMapping("/disable/{id}")
    public ResponseEntity<?>disable(@PathVariable("id") final long id){
        try {
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
