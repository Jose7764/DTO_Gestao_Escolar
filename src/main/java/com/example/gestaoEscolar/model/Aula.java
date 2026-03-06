package com.example.gestaoEscolar.model;

import java.time.LocalDateTime;


public class Aula {

    private Long id;
    private Long turmaId;
    private LocalDateTime dataHora;
    private String assunto;

    public Aula() {
    }

    public Aula(Long turmaId, LocalDateTime dataHora, String assunto) {
        this.turmaId = turmaId;
        this.dataHora = dataHora;
        this.assunto = assunto;
    }

}