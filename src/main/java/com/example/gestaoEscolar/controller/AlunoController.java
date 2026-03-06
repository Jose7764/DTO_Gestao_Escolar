package com.example.gestaoEscolar.controller;


import com.example.gestaoEscolar.dto.Aluno.AlunoRequestDto;
import com.example.gestaoEscolar.dto.Aluno.AlunoResponseDto;
import com.example.gestaoEscolar.service.AlunoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;


@RestController
@RequestMapping("/Aluno")
@RequiredArgsConstructor

public class AlunoController {
    private final AlunoService service;

    @GetMapping
    public List<AlunoResponseDto> listarAlunos(){

        try {
            return service.listarAlunos();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{id}")
    public AlunoResponseDto buscarAlunoPorId(@PathVariable long id){
        try {
            return service.buscarAlunoPorId(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping
    public AlunoResponseDto salvarAluno(@RequestBody AlunoRequestDto aluno){
        try {
            return service.salvarAluno(aluno);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public AlunoResponseDto atualizarAluno(@PathVariable long id, @RequestBody AlunoRequestDto aluno){
        try {
            return service.atualizarAluno(aluno,id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/{id}")
    public String deletarAluno(@PathVariable long id){
        try {
            return service.deletarAluno(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
