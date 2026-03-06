package com.example.gestaoEscolar.repository;

import com.example.gestaoEscolar.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfRepository extends JpaRepository<Professor,Long> {
}
