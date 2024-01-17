package com.example.springboot.serie.controllers;


import com.example.springboot.serie.dtos.SerieRecordDto;
import com.example.springboot.serie.models.SerieModel;
import com.example.springboot.serie.service.SerieService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;



@RestController
public class SerieController {
    @Autowired
    SerieService serieService;



    @PostMapping("/serie")
    public ResponseEntity<SerieModel> saveSerie(@RequestBody @Valid SerieRecordDto serieRecordDto) {
        var serieModel = new SerieModel();
        BeanUtils.copyProperties(serieRecordDto, serieModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(serieService.save(serieModel));
    }

    @GetMapping("/serie")
    public ResponseEntity<List<SerieModel>> getAllSerie(){
        return ResponseEntity.status(HttpStatus.OK).body(serieService.findAll());
    }

    @GetMapping("/serie/{id}")
    public ResponseEntity<Object> getoneSerie(@PathVariable(value="id") UUID id){
        Optional<SerieModel> serieO = serieService.findById(id);
        if(serieO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(serieO.get());
    }

    @PutMapping("/serie/{id}")
    public ResponseEntity<Object> updateSerie(@PathVariable(value="id") UUID id,
                                                   @RequestBody @Valid SerieRecordDto serieRecordDto) {
        Optional<SerieModel> serieO = serieService.findById(id);
        if(serieO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }
        var serieModel = serieO.get();
        BeanUtils.copyProperties(serieRecordDto, serieModel);
        return ResponseEntity.status(HttpStatus.OK).body(serieService.save(serieModel));
    }

    @DeleteMapping("/serie/{id}")
    public ResponseEntity<Object> deleteSerie(@PathVariable(value="id") UUID id) {
        Optional<SerieModel> serieO = serieService.findById(id);
        if(serieO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
        serieService.delete(serieO.get());
        return ResponseEntity.status(HttpStatus.OK).body("Product deleted sucessfully.");
    }
}









