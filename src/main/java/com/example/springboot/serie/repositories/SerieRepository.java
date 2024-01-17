package com.example.springboot.serie.repositories;


import com.example.springboot.serie.models.SerieModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SerieRepository extends JpaRepository<SerieModel, UUID> {
}
