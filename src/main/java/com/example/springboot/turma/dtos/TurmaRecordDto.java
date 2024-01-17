package com.example.springboot.turma.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record TurmaRecordDto(@NotBlank String name, @NotNull BigDecimal value) {
}
