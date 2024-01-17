package com.example.springboot.disciplina.repositories;


import com.example.springboot.disciplina.models.DisciplinaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DisciplinaRepository extends JpaRepository<DisciplinaModel, UUID> {
}

