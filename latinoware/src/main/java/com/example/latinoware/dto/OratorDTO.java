package com.example.latinoware.dto;


import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class OratorDTO extends AbstractEntityDTO{
    @Size(min= 3, max = 40, message = "No mínimo 3 e no máximo 40 caracteres.")
    private String name;
    private Integer age;
    @Size(min= 2, max = 30, message = "No mínimo 2 e no máximo 30 caracteres.")
    private String jobTitle;
    @Size(min=3, max = 50, message = "No mínimo 3 e no máximo 50 caracteres")
    private String companyName;
}
