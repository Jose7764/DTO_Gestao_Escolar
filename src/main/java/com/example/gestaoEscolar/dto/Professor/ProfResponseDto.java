package com.example.gestaoEscolar.dto.Professor;

public record ProfResponseDto (
        long id,
        String nome,
        String email,
        String disciplina
){
}
