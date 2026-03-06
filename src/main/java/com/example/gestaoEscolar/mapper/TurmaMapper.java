package com.example.gestaoEscolar.mapper;

import com.example.gestaoEscolar.dto.Turma.TurmaRequestDro;
import com.example.gestaoEscolar.dto.Turma.TurmaResponseDto;
import com.example.gestaoEscolar.model.Turma;
import org.springframework.stereotype.Component;

@Component
public class TurmaMapper {

    public Turma toEntity(TurmaRequestDro dto){
        return new Turma(
                dto.nome(),
                dto.curso_id(),
                dto.professor_id()
        );
    }

    public TurmaResponseDto toResponse(Turma turma){
        return new TurmaResponseDto(
                turma.getId(),
                turma.getNome(),
                turma.getCursoId(),
                turma.getProfessorId()
        );
    }
}
