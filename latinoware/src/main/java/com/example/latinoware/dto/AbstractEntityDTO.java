package com.example.latinoware.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class AbstractEntityDTO {
    private Long id;
    private LocalDateTime registerDate;
    private LocalDateTime update;
    private boolean active;
    private LocalDateTime deleted;

    public void disable(){
        this.deleted = LocalDateTime.now();
        this.active = false;
    }
    public void enable() {
        this.active = true;
        this.update = LocalDateTime.now();
    }

    public void update(){
        this.update = LocalDateTime.now();
    }

}
