package com.example.springboot.disciplina.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record DisciplinaRecordDto(@NotBlank String name, @NotNull BigDecimal value) {
}
