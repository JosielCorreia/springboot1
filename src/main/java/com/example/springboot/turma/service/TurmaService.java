package com.example.springboot.turma.service;


import com.example.springboot.turma.models.TurmaModel;
import com.example.springboot.turma.repositories.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TurmaService {

    @Autowired
    TurmaRepository turmaRepository;
    public TurmaModel save(TurmaModel entity) {
        return turmaRepository.save(entity);
    }
    public List<TurmaModel> findAll() {
        return turmaRepository.findAll();
    }
    public Optional<TurmaModel> findById(UUID id) {
        return turmaRepository.findById(id);
    }
    public void delete(TurmaModel turmaModel) {
        turmaRepository.delete(turmaModel);
    }
}
