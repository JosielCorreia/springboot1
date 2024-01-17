package com.example.springboot.professor.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProfessorRecordDto(@NotBlank String name, @NotNull BigDecimal value) {
}
