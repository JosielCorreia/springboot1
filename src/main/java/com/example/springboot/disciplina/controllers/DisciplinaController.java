package com.example.springboot.disciplina.controllers;


import com.example.springboot.disciplina.dtos.DisciplinaRecordDto;
import com.example.springboot.disciplina.models.DisciplinaModel;
import com.example.springboot.disciplina.service.DisciplinaService;
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
public class DisciplinaController {
    @Autowired
    DisciplinaService disciplinaService;



    @PostMapping("/disciplina")
    public ResponseEntity<DisciplinaModel> saveDisciplina(@RequestBody @Valid DisciplinaRecordDto disciplinaRecordDto) {
        var disciplinaModel = new DisciplinaModel();
        BeanUtils.copyProperties(disciplinaRecordDto, disciplinaModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(disciplinaService.save(disciplinaModel));
    }

    @GetMapping("/disciplina")
    public ResponseEntity<List<DisciplinaModel>> getAllDisciplina(){
        return ResponseEntity.status(HttpStatus.OK).body(disciplinaService.findAll());
    }

    @GetMapping("/disciplina/{id}")
    public ResponseEntity<Object> getoneDisciplina(@PathVariable(value="id") UUID id){
        Optional<DisciplinaModel> disciplinaO = disciplinaService.findById(id);
        if(disciplinaO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(disciplinaO.get());
    }

    @PutMapping("/disciplina/{id}")
    public ResponseEntity<Object> updateDisciplina(@PathVariable(value="id") UUID id,
                                               @RequestBody @Valid DisciplinaRecordDto disciplinaRecordDto) {
        Optional<DisciplinaModel> disciplinaO = disciplinaService.findById(id);
        if(disciplinaO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }
        var disciplinaModel = disciplinaO.get();
        BeanUtils.copyProperties(disciplinaRecordDto, disciplinaModel);
        return ResponseEntity.status(HttpStatus.OK).body(disciplinaService.save(disciplinaModel));
    }

    @DeleteMapping("/disciplina/{id}")
    public ResponseEntity<Object> deleteDisciplina(@PathVariable(value="id") UUID id) {
        Optional<DisciplinaModel> disciplinaO = disciplinaService.findById(id);
        if(disciplinaO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
        disciplinaService.delete(disciplinaO.get());
        return ResponseEntity.status(HttpStatus.OK).body("Product deleted sucessfully.");
    }
}









