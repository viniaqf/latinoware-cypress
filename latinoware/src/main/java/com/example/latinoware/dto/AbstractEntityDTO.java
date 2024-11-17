package com.example.latinoware.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class AbstractEntityDTO {

    private Long id;
    private LocalDateTime register;
    private LocalDateTime update;
    private boolean active;
    private LocalDateTime deleted;

    public void disable(){
        this.deleted = LocalDateTime.now();
    }
    public void enable() {
        this.deleted = null;
    }


}
