package com.example.gestaoEscolar.dto.Turma;

public record TurmaRequestDro(
        String nome,
        long curso_id,
        long professor_id
) {
}
