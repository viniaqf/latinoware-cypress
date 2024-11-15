package com.example.latinoware.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;


import java.time.LocalDateTime;

@Entity
@Table(name = "clientes", schema = "public")
@AllArgsConstructor @NoArgsConstructor
public class Event extends AbstractEntity {

    @Getter @Setter
    @Column(name = "eventName", nullable = false, unique = true)
    private String name;

    @Getter @Setter
    @Column(name = "eventDate", nullable = false)
    private LocalDateTime date;

    @Getter @Setter
    @Column(name = "eventLocation", nullable = false)
    private EventLocation location;

    @Getter @Setter
    @Column(name = "eventOrator", nullable = false)
    private Orator orator;
}
