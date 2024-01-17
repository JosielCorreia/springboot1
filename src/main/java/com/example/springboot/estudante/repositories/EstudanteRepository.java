package com.example.springboot.estudante.repositories;


import com.example.springboot.estudante.models.EstudanteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EstudanteRepository extends JpaRepository<EstudanteModel, UUID> {
}
