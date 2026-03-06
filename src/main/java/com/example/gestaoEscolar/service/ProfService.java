package com.example.gestaoEscolar.service;

import com.example.gestaoEscolar.dto.Professor.ProfRequestDto;
import com.example.gestaoEscolar.dto.Professor.ProfResponseDto;
import com.example.gestaoEscolar.mapper.ProfMapper;
import com.example.gestaoEscolar.model.Professor;
import com.example.gestaoEscolar.repository.ProfRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfService {

    private final ProfRepository repository;
    private final ProfMapper mapper;

    public ProfResponseDto criarProfessor(ProfRequestDto professorRequest)throws SQLException {

        Professor professor = mapper.toEntity(professorRequest);
        Professor professor1 = repository.save(professor);
        ProfResponseDto professorResponse = mapper.toResponse(professor1);

        return professorResponse;
    }

    public List<ProfResponseDto> listarProfessor () throws SQLException{

        List<Professor> professores = repository.findAll();
        List<ProfResponseDto> dtos = new ArrayList<>();

        for(Professor professor : professores){
            dtos.add(mapper.toResponse(professor));
        }
        return dtos;
    }

    public ProfResponseDto listarProfessorPorId(long id)throws SQLException{

        Optional<Professor> professor = repository.findById(id);
        ProfResponseDto professorResponse = mapper.toResponse(professor.get());

        return professorResponse;
    }

    public ProfResponseDto atualizarProfessor(long id, ProfRequestDto professorRequest) throws SQLException{

        Professor professor = repository.findById(id).orElseThrow(() -> new RuntimeException("Falha ao atualizar"));

        professor.setNome(professorRequest.nome());
        professor.setEmail(professorRequest.email());
        professor.setDisciplina(professorRequest.disciplina());
        Professor professor1 = repository.save(professor);

        ProfResponseDto professorResponse = mapper.toResponse(professor);

        return professorResponse;
    }

    public String removerProfessor(long id) throws SQLException{

        Professor professor = repository.findById(id).orElseThrow(() -> new RuntimeException("Falha ao atualizar"));

        repository.delete(professor);
        return "Professor "+ professor.getNome() + ", foi deletado com sucesso.";
    }
}
