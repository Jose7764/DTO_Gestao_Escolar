package com.example.gestaoEscolar.mapper;

import com.example.gestaoEscolar.dto.Professor.ProfRequestDto;
import com.example.gestaoEscolar.dto.Professor.ProfResponseDto;
import com.example.gestaoEscolar.model.Professor;
import org.springframework.stereotype.Component;

@Component
public class ProfMapper {

    public Professor toEntity(ProfRequestDto dto){
        return new Professor(
                dto.nome(),
                dto.email(),
                dto.disciplina()
        );
    }

    public ProfResponseDto toResponse(Professor prof){
        return new ProfResponseDto(
                prof.getId(),
                prof.getNome(),
                prof.getEmail(),
                prof.getDisciplina()
        );
    }
}
