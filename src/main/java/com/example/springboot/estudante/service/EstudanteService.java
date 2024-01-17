package com.example.springboot.estudante.service;


import com.example.springboot.estudante.models.EstudanteModel;
import com.example.springboot.estudante.repositories.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EstudanteService {

    @Autowired
    EstudanteRepository estudanteRepository;
    public EstudanteModel save(EstudanteModel entity) {
        return estudanteRepository.save(entity);
    }
    public List<EstudanteModel> findAll() {
        return estudanteRepository.findAll();
    }
    public Optional<EstudanteModel> findById(UUID id) {
        return estudanteRepository.findById(id);
    }
    public void delete(EstudanteModel estudanteModel) {
        estudanteRepository.delete(estudanteModel);
    }
}
