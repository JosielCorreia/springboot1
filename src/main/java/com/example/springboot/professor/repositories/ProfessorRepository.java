package com.example.springboot.professor.repositories;


import com.example.springboot.professor.models.ProfessorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProfessorRepository extends JpaRepository<ProfessorModel, UUID> {
}
