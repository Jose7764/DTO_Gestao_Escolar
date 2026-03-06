package com.example.gestaoEscolar.controller;

import com.example.gestaoEscolar.dto.Curso.CursoRequestDto;
import com.example.gestaoEscolar.dto.Curso.CursoResponseDto;
import com.example.gestaoEscolar.service.CursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/Curso")
@RequiredArgsConstructor
public class CursoController {

    private final CursoService service;


    @PostMapping
    public CursoResponseDto salvarCurso(@RequestBody CursoRequestDto dto){
        try{
            return service.salvarCurso(dto);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping
    public List<CursoResponseDto> listarCursos(){
        return service.listarCursos();
    }

    @GetMapping("/{id}")
    public CursoResponseDto listarCursoPorId(@PathVariable long id){
        try {
            return service.listarCursoPorId(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/{id}")
    public CursoResponseDto atualizarCurso(@PathVariable long id, @RequestBody CursoRequestDto dto){
        try {
            return service.atualizarCurso(id,dto);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/{id}")
    public String deleteCurso(@PathVariable long id){
        try {
            return service.deletarCurso(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
