package com.example.gestaoEscolar.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Turma {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "nome" , nullable = false)
    private String nome;

    @Column(name = "curso_id" , nullable = false)
    private Long cursoId;

    @Column(name = "professor_id" , nullable = false)
    private Long professorId;


    public Turma( String nome, Long cursoId, Long professorId) {
        this.nome = nome;
        this.cursoId = cursoId;
        this.professorId = professorId;
    }


}