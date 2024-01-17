package com.example.springboot.serie.service;


import com.example.springboot.serie.models.SerieModel;
import com.example.springboot.serie.repositories.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SerieService {

    @Autowired
    SerieRepository serieRepository;
    public SerieModel save(SerieModel entity) {
        return serieRepository.save(entity);
    }
    public List<SerieModel> findAll() {
        return serieRepository.findAll();
    }
    public Optional<SerieModel> findById(UUID id) {
        return serieRepository.findById(id);
    }
    public void delete(SerieModel serieModel) {
        serieRepository.delete(serieModel);
    }
}
