package com.example.gestaoEscolar.mapper;

import com.example.gestaoEscolar.dto.Curso.CursoRequestDto;
import com.example.gestaoEscolar.dto.Curso.CursoResponseDto;
import com.example.gestaoEscolar.model.Curso;
import org.springframework.stereotype.Component;


@Component
public class CursoMapper {

    public Curso toEntity(CursoRequestDto dto){
        return new Curso(
                dto.nome(),
                dto.codigo()
        );
    }

    public CursoResponseDto toResponse(Curso curso){
        return new CursoResponseDto(
                curso.getId(),
                curso.getNome(),
                curso.getCodigo()
        );
    }
}
