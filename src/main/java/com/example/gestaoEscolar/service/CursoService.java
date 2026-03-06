package com.example.gestaoEscolar.service;

import com.example.gestaoEscolar.dto.Curso.CursoRequestDto;
import com.example.gestaoEscolar.dto.Curso.CursoResponseDto;
import com.example.gestaoEscolar.mapper.CursoMapper;
import com.example.gestaoEscolar.model.Curso;
import com.example.gestaoEscolar.repository.CursoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor

public class CursoService {

    private final CursoRepository repository;
    private final CursoMapper mapper;

    public List<CursoResponseDto> listarCursos(){

        return repository.findAll().stream()
                .map(mapper::toResponse)
                .toList();
    }

    public CursoResponseDto salvarCurso(CursoRequestDto dto)throws SQLException {

        Curso curso = mapper.toEntity(dto);
        return mapper.toResponse(repository.save(curso));
    }


    public CursoResponseDto listarCursoPorId(long id)throws SQLException{

        Curso curso = repository.findById(id).orElseThrow(()->new RuntimeException());

        return mapper.toResponse(curso);
    }

    public CursoResponseDto atualizarCurso(long id, CursoRequestDto dto)throws SQLException{

        Curso curso = repository.findById(id).orElseThrow(()->new RuntimeException());

        curso.setNome(dto.nome());
        curso.setCodigo(dto.codigo());

        return mapper.toResponse(curso);
    }

    public String deletarCurso(long id)throws SQLException{
        Curso curso = repository.findById(id).orElseThrow(()->new RuntimeException());

        repository.delete(curso);
        return "Curso de " +curso.getNome()+", deletado com sucesso.";
    }

}
