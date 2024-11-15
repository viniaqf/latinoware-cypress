package com.example.latinoware.entity;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;

@MappedSuperclass
public class AbstractEntity {

private Long id;
private LocalDateTime cadastro;
private LocalDateTime edicao;
private boolean ativo;

@PrePersist
    private void prePersist(){
    this.cadastro = LocalDateTime.now();
    }
@PreUpdate
    private void preUpdate(){
    this.edicao = LocalDateTime.now();
    }

}
