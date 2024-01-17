package com.example.springboot.turma.controllers;


import com.example.springboot.turma.dtos.TurmaRecordDto;
import com.example.springboot.turma.models.TurmaModel;
import com.example.springboot.turma.service.TurmaService;
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
public class TurmaController {
    @Autowired
    TurmaService turmaService;



    @PostMapping("/turma")
    public ResponseEntity<TurmaModel> saveTurma(@RequestBody @Valid TurmaRecordDto turmaRecordDto) {
        var turmaModel = new TurmaModel();
        BeanUtils.copyProperties(turmaRecordDto, turmaModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(turmaService.save(turmaModel));
    }

    @GetMapping("/turma")
    public ResponseEntity<List<TurmaModel>> getAllTurma(){
        return ResponseEntity.status(HttpStatus.OK).body(turmaService.findAll());
    }

    @GetMapping("/turma/{id}")
    public ResponseEntity<Object> getoneTurma(@PathVariable(value="id") UUID id){
        Optional<TurmaModel> turmaO = turmaService.findById(id);
        if(turmaO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(turmaO.get());
    }

    @PutMapping("/turma/{id}")
    public ResponseEntity<Object> updateTurma(@PathVariable(value="id") UUID id,
                                                   @RequestBody @Valid TurmaRecordDto turmaRecordDto) {
        Optional<TurmaModel> turmaO = turmaService.findById(id);
        if(turmaO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }
        var turmaModel = turmaO.get();
        BeanUtils.copyProperties(turmaRecordDto, turmaModel);
        return ResponseEntity.status(HttpStatus.OK).body(turmaService.save(turmaModel));
    }

    @DeleteMapping("/turma/{id}")
    public ResponseEntity<Object> deleteTurma(@PathVariable(value="id") UUID id) {
        Optional<TurmaModel> turmaO = turmaService.findById(id);
        if(turmaO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
        turmaService.delete(turmaO.get());
        return ResponseEntity.status(HttpStatus.OK).body("Product deleted sucessfully.");
    }
}









