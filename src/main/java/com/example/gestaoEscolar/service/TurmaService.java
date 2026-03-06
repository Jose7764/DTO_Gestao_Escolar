package com.example.gestaoEscolar.service;

import com.example.gestaoEscolar.dto.Turma.TurmaRequestDro;
import com.example.gestaoEscolar.dto.Turma.TurmaResponseDto;
import com.example.gestaoEscolar.mapper.TurmaMapper;
import com.example.gestaoEscolar.model.Turma;
import com.example.gestaoEscolar.repository.TurmaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TurmaService {

    private final TurmaRepository repository;
    private final TurmaMapper mapper;

    public TurmaResponseDto salvarTurma(TurmaRequestDro dto){

        Turma turma = mapper.toEntity(dto);
        return mapper.toResponse(repository.save(turma));
    }

    public List<TurmaResponseDto> listarTurmas(){

        return repository.findAll().stream()
                .map(mapper::toResponse)
                .toList();
    }

    public TurmaResponseDto listarTurmaPorId(long id){

        Turma turma = repository.findById(id).orElseThrow(()->new RuntimeException("Turma não encontrada!!"));
        return mapper.toResponse(turma);
    }

    public TurmaResponseDto atualizarTurma (TurmaRequestDro dto, long id){

        Turma turma =  repository.findById(id).orElseThrow(()->new RuntimeException("Turma não encontrada!!"));

        turma.setNome(dto.nome());
        turma.setCursoId(dto.curso_id());
        turma.setProfessorId(dto.professor_id());

        return mapper.toResponse(repository.save(turma));
    }

    public String deleteTurma(long id){

        Turma turma =  repository.findById(id).orElseThrow(()->new RuntimeException("Turma não encontrada!!"));
        repository.delete(turma);

        return "A Turma "+turma.getNome()+" Acabou de ser deletada";
    }
}
