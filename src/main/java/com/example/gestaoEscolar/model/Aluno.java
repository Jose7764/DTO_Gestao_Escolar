package com.example.gestaoEscolar.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.Date;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "matricula", nullable = false)
    private String matricula;

    @Column(name = "data_nascimento", nullable = false)
    private Date dataNascimento;

    public Aluno(String nome, String email, String matricula, Date dataNascimento) {
        this.nome = nome;
        this.email = email;
        this.matricula = matricula;
        this.dataNascimento = dataNascimento;
    }

}