package com.example.springboot.escola.repositories;


import com.example.springboot.escola.models.EscolaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EscolaRepository extends JpaRepository<EscolaModel, UUID> {
}
