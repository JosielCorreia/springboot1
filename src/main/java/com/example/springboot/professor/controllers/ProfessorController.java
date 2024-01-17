package com.example.springboot.professor.controllers;


import com.example.springboot.professor.dtos.ProfessorRecordDto;
import com.example.springboot.professor.models.ProfessorModel;
import com.example.springboot.professor.service.ProfessorService;
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
public class ProfessorController {
    @Autowired
    ProfessorService professorService;



    @PostMapping("/professor")
    public ResponseEntity<ProfessorModel> saveProfessor(@RequestBody @Valid ProfessorRecordDto professorRecordDto) {
        var professorModel = new ProfessorModel();
        BeanUtils.copyProperties(professorRecordDto, professorModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(professorService.save(professorModel));
    }

    @GetMapping("/professor")
    public ResponseEntity<List<ProfessorModel>> getAllProfessor(){
        return ResponseEntity.status(HttpStatus.OK).body(professorService.findAll());
    }

    @GetMapping("/professor/{id}")
    public ResponseEntity<Object> getoneProfessor(@PathVariable(value="id") UUID id){
        Optional<ProfessorModel> professorO = professorService.findById(id);
        if(professorO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(professorO.get());
    }

    @PutMapping("/professor/{id}")
    public ResponseEntity<Object> updateProfessor(@PathVariable(value="id") UUID id,
                                                   @RequestBody @Valid ProfessorRecordDto professorRecordDto) {
        Optional<ProfessorModel> professorO = professorService.findById(id);
        if(professorO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }
        var professorModel = professorO.get();
        BeanUtils.copyProperties(professorRecordDto, professorModel);
        return ResponseEntity.status(HttpStatus.OK).body(professorService.save(professorModel));
    }

    @DeleteMapping("/professor/{id}")
    public ResponseEntity<Object> deleteProfessor(@PathVariable(value="id") UUID id) {
        Optional<ProfessorModel> professorO = professorService.findById(id);
        if(professorO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
        professorService.delete(professorO.get());
        return ResponseEntity.status(HttpStatus.OK).body("Product deleted sucessfully.");
    }
}









