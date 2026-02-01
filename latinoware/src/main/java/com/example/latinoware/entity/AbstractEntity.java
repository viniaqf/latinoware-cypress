package com.example.latinoware.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@MappedSuperclass
public class AbstractEntity {

    @Id
    @Getter @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Getter @Setter
    @Column(name = "dtCadastro", nullable = false)
    private LocalDateTime registerDate;

    @Getter @Setter
    @Column(name = "dtEdicao")
    private LocalDateTime update;

    @Getter @Setter
    @Column(name="dtDelecao")
    private LocalDateTime deleted;

    @Getter @Setter
    @Column(name = "isAtivo", nullable = false)
    private boolean active;

@PrePersist
    private void prePersist(){
    this.registerDate = LocalDateTime.now();
    this.active = true;
    this.deleted = null;
    }
@PreUpdate
    private void preUpdate(){
    this.update = LocalDateTime.now();
    }

}
