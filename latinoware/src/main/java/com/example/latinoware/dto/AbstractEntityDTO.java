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
    private LocalDateTime cadastro;
    private LocalDateTime edicao;
    private boolean ativo;
    private LocalDateTime delecao;

    public void desativar(){
        this.delecao = LocalDateTime.now();
    }
    public void ativar() {
        this.delecao = null;
    }


}
