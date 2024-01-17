package com.example.springboot.turma.repositories;


import com.example.springboot.turma.models.TurmaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TurmaRepository extends JpaRepository<TurmaModel, UUID> {
}
