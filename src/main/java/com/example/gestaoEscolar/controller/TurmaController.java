package com.example.gestaoEscolar.controller;

import com.example.gestaoEscolar.dto.Turma.TurmaRequestDro;
import com.example.gestaoEscolar.dto.Turma.TurmaResponseDto;
import com.example.gestaoEscolar.service.TurmaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Turma")
@RequiredArgsConstructor
public class TurmaController {

    public final TurmaService service;

    @GetMapping
    public List<TurmaResponseDto> listarTurmas(){
        try {
            return service.listarTurmas();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{id}")
    public TurmaResponseDto listarTurmaPorId(@PathVariable long id){
        try {
            return service.listarTurmaPorId(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping
    public TurmaResponseDto salvarTurma(@RequestBody TurmaRequestDro dto){
        try {
            return service.salvarTurma(dto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/{id}")
    public TurmaResponseDto atualizarTurma(@PathVariable long id, @RequestBody TurmaRequestDro dto){
        try {
            return service.atualizarTurma(dto, id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/{id}")
    public String deleteTurma(@PathVariable long id){
        try {
            return service.deleteTurma(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
