package com.example.latinoware.dto;


import com.example.latinoware.entity.Event;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class OratorDTO extends AbstractEntityDTO{
    private String name;
    private Integer age;
    private String jobTitle;
    private String companyName;
    @JsonIgnoreProperties("orator")
    private List<Event>event;
}
