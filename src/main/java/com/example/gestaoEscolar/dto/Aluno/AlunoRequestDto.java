package com.example.gestaoEscolar.dto.Aluno;

import java.sql.Date;

public record AlunoRequestDto (
        String nome,
        String email,
        String matricula,
        Date dataNascimento
){
}
