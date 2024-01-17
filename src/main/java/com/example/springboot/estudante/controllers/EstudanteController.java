package com.example.springboot.estudante.controllers;


import com.example.springboot.estudante.dtos.EstudanteRecordDto;
import com.example.springboot.estudante.models.EstudanteModel;
import com.example.springboot.estudante.service.EstudanteService;
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
public class EstudanteController {
    @Autowired
    EstudanteService estudanteService;



    @PostMapping("/estudante")
    public ResponseEntity<EstudanteModel> saveEstudante(@RequestBody @Valid EstudanteRecordDto estudanteRecordDto) {
        var estudanteModel = new EstudanteModel();
        BeanUtils.copyProperties(estudanteRecordDto, estudanteModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(estudanteService.save(estudanteModel));
    }

    @GetMapping("/estudante")
    public ResponseEntity<List<EstudanteModel>> getAllEstudante(){
        return ResponseEntity.status(HttpStatus.OK).body(estudanteService.findAll());
    }

    @GetMapping("/estudante/{id}")
    public ResponseEntity<Object> getoneEstudante(@PathVariable(value="id") UUID id){
        Optional<EstudanteModel> estudanteO = estudanteService.findById(id);
        if(estudanteO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(estudanteO.get());
    }

    @PutMapping("/estudante/{id}")
    public ResponseEntity<Object> updateEstudante(@PathVariable(value="id") UUID id,
                                               @RequestBody @Valid EstudanteRecordDto estudanteRecordDto) {
        Optional<EstudanteModel> estudanteO = estudanteService.findById(id);
        if(estudanteO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }
        var estudanteModel = estudanteO.get();
        BeanUtils.copyProperties(estudanteRecordDto, estudanteModel);
        return ResponseEntity.status(HttpStatus.OK).body(estudanteService.save(estudanteModel));
    }

    @DeleteMapping("/estudante/{id}")
    public ResponseEntity<Object> deleteEstudante(@PathVariable(value="id") UUID id) {
        Optional<EstudanteModel> estudanteO = estudanteService.findById(id);
        if(estudanteO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
        estudanteService.delete(estudanteO.get());
        return ResponseEntity.status(HttpStatus.OK).body("Product deleted sucessfully.");
    }
}









