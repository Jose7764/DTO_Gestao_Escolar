package com.example.gestaoEscolar.controller;

import com.example.gestaoEscolar.dto.Professor.ProfRequestDto;
import com.example.gestaoEscolar.dto.Professor.ProfResponseDto;
import com.example.gestaoEscolar.service.ProfService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;


@RestController
@RequestMapping("/professor")
@RequiredArgsConstructor
public class ProfessorController {

    private final ProfService professorService;

    @PostMapping
    public ProfResponseDto criarProfessor (@RequestBody ProfRequestDto professor){

        try{
            return professorService.criarProfessor(professor);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping
    public List<ProfResponseDto> listarProfessores (){
        try{
            return professorService.listarProfessor();
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ProfResponseDto listarProfessorPorId(@PathVariable long id){
        try{
            return professorService.listarProfessorPorId(id);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ProfResponseDto atualizarProfessor(@PathVariable long id, @RequestBody ProfRequestDto professorRequest){

        try{
            return professorService.atualizarProfessor(id, professorRequest);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public String removerProfessor(@PathVariable long id){
        try{
            return professorService.removerProfessor(id);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
