package com.example.springboot.escola.service;


import com.example.springboot.escola.models.EscolaModel;
import com.example.springboot.escola.repositories.EscolaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EscolaService {

    @Autowired
    EscolaRepository escolaRepository;
    public EscolaModel save(EscolaModel entity) {
        return escolaRepository.save(entity);
    }
    public List<EscolaModel> findAll() {
        return escolaRepository.findAll();
    }
    public Optional<EscolaModel> findById(UUID id) {
        return escolaRepository.findById(id);
    }
    public void delete(EscolaModel escolaModel) {
        escolaRepository.delete(escolaModel);
    }
}
