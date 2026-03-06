package com.example.gestaoEscolar.mapper;

import com.example.gestaoEscolar.dto.Aluno.AlunoRequestDto;
import com.example.gestaoEscolar.dto.Aluno.AlunoResponseDto;
import com.example.gestaoEscolar.model.Aluno;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AlunoMapper {

    public Aluno toEntity(AlunoRequestDto responseDto){
        return new Aluno(
                responseDto.nome(),
                responseDto.email(),
                responseDto.matricula(),
                responseDto.dataNascimento()
        );
    }

    public AlunoResponseDto toResponse(Aluno aluno){
        return new AlunoResponseDto(
                aluno.getId(),
                aluno.getNome(),
                aluno.getEmail(),
                aluno.getMatricula(),
                aluno.getDataNascimento()
        );
    }
}
