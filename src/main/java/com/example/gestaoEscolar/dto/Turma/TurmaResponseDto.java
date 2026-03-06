package com.example.gestaoEscolar.dto.Turma;

public record TurmaResponseDto(
        long id,
        String nome,
        long curso_id,
        long professor_id
) {

}
