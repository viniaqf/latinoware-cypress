package com.example.latinoware.entity;

import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDateTime;

@Entity
@Table(name = "tb_event", schema = "public")
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

    @ManyToOne
    @Getter @Setter
    @JoinColumn(name = "orator_id", nullable = false)
    private Orator orator;
}
