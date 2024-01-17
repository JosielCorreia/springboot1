package com.example.springboot.escola.controllers;

import com.example.springboot.escola.dtos.EscolaRecordDto;
import com.example.springboot.escola.models.EscolaModel;
import com.example.springboot.escola.service.EscolaService;
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
public class EscolaController {
    @Autowired
    EscolaService escolaService;



    @PostMapping("/escola")
    public ResponseEntity<EscolaModel> saveEscola(@RequestBody @Valid EscolaRecordDto escolaRecordDto) {
        var escolaModel = new EscolaModel();
        BeanUtils.copyProperties(escolaRecordDto, escolaModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(escolaService.save(escolaModel));
    }

    @GetMapping("/escola")
    public ResponseEntity<List<EscolaModel>> getAllEscola(){
        return ResponseEntity.status(HttpStatus.OK).body(escolaService.findAll());
    }

    @GetMapping("/escola/{id}")
    public ResponseEntity<Object> getoneEscola(@PathVariable(value="id") UUID id){
        Optional<EscolaModel> escolaO = escolaService.findById(id);
        if(escolaO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(escolaO.get());
    }

    @PutMapping("/escola/{id}")
    public ResponseEntity<Object> updateEscola(@PathVariable(value="id") UUID id,
                                                   @RequestBody @Valid EscolaRecordDto escolaRecordDto) {
        Optional<EscolaModel> escolaO = escolaService.findById(id);
        if(escolaO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }
        var escolaModel = escolaO.get();
        BeanUtils.copyProperties(escolaRecordDto, escolaModel);
        return ResponseEntity.status(HttpStatus.OK).body(escolaService.save(escolaModel));
    }

    @DeleteMapping("/escola/{id}")
    public ResponseEntity<Object> deleteEscola(@PathVariable(value="id") UUID id) {
        Optional<EscolaModel> escolaO = escolaService.findById(id);
        if(escolaO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
        escolaService.delete(escolaO.get());
        return ResponseEntity.status(HttpStatus.OK).body("Product deleted sucessfully.");
    }
}









