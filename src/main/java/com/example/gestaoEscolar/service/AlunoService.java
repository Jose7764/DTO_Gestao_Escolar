package com.example.gestaoEscolar.service;

import com.example.gestaoEscolar.dto.Aluno.AlunoRequestDto;
import com.example.gestaoEscolar.dto.Aluno.AlunoResponseDto;
import com.example.gestaoEscolar.mapper.AlunoMapper;
import com.example.gestaoEscolar.model.Aluno;
import com.example.gestaoEscolar.repository.AlunoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository repository;
    private final AlunoMapper mapper;


    public List<AlunoResponseDto> listarAlunos()throws SQLException {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    public AlunoResponseDto buscarAlunoPorId(long id)throws SQLException{

        Optional <Aluno> aluno = repository.findById(id);
        AlunoResponseDto alunoResponseDto = mapper.toResponse(aluno.get());
        return alunoResponseDto;
    }

    public AlunoResponseDto salvarAluno(AlunoRequestDto aluno)throws SQLException{

        Aluno alunoEntity =  mapper.toEntity(aluno);
        return mapper.toResponse(repository.save(alunoEntity));
    }

    public AlunoResponseDto atualizarAluno(AlunoRequestDto dto, long id)throws SQLException{

        Aluno aluno = repository.findById(id).orElseThrow(() ->new RuntimeException("Aluno não Econtrado"));

        aluno.setNome(dto.nome());
        aluno.setEmail(dto.email());
        aluno.setMatricula(dto.matricula());
        aluno.setDataNascimento(dto.dataNascimento());

        aluno = repository.save(aluno);

        return mapper.toResponse(aluno);
    }

    public String deletarAluno(long id)throws SQLException{
        Aluno aluno = repository.findById(id).orElseThrow(() ->new RuntimeException("Aluno não Econtrado"));
        repository.delete(aluno);

        return "O Aluno "+aluno.getNome()+" foi eliminado.";
    }

}
