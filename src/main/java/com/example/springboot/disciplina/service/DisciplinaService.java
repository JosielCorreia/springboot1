package com.example.springboot.disciplina.service;


import com.example.springboot.disciplina.models.DisciplinaModel;
import com.example.springboot.disciplina.repositories.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DisciplinaService {

    @Autowired
    DisciplinaRepository disciplinaRepository;
    public DisciplinaModel save(DisciplinaModel entity) {
        return disciplinaRepository.save(entity);
    }
    public List<DisciplinaModel> findAll() {
        return disciplinaRepository.findAll();
    }
    public Optional<DisciplinaModel> findById(UUID id) {
        return disciplinaRepository.findById(id);
    }
    public void delete(DisciplinaModel disciplinaModel) {
         disciplinaRepository.delete(disciplinaModel);
    }
}
