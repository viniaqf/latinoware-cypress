package com.example.latinoware.dto;

import com.example.latinoware.entity.EventLocation;
import com.example.latinoware.entity.Orator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class EventDTO {

    private String name;
    private LocalDateTime date;
    private EventLocation location;
    private Orator orator;
}
