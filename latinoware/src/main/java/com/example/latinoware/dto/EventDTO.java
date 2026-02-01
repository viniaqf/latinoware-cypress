package com.example.latinoware.dto;

import com.example.latinoware.entity.EventLocation;
import com.example.latinoware.entity.Orator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class EventDTO extends AbstractEntityDTO{
    private String name;
    private LocalDateTime eventDate;
    private EventLocation location;
    @JsonIgnoreProperties("events")
    private Orator orator;
}
