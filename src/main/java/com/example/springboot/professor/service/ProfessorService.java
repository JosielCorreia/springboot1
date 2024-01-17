package com.example.springboot.professor.service;


import com.example.springboot.professor.models.ProfessorModel;
import com.example.springboot.professor.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProfessorService {

    @Autowired
    ProfessorRepository professorRepository;
    public ProfessorModel save(ProfessorModel entity) {
        return professorRepository.save(entity);
    }
    public List<ProfessorModel> findAll() {
        return professorRepository.findAll();
    }
    public Optional<ProfessorModel> findById(UUID id) {
        return professorRepository.findById(id);
    }
    public void delete(ProfessorModel professorModel) {
        professorRepository.delete(professorModel);
    }
}
