package com.example.gestaoEscolar.dto.Aluno;

import java.sql.Date;

public record AlunoResponseDto (
        long id,
        String nome,
        String email,
        String matricula,
        Date dataNascimento
){
}
