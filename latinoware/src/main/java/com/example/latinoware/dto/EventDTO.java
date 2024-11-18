package com.example.latinoware.dto;

import com.example.latinoware.entity.EventLocation;
import com.example.latinoware.entity.Orator;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class EventDTO extends AbstractEntityDTO{
    @Size(min = 3, max = 50, message = "No mínimo 3 e no máximo 50 caracteres.")
    private String name;
    private LocalDateTime date;
    private EventLocation location;
    private Orator orator;
}
