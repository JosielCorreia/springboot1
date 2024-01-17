package com.example.springboot.estudante.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record EstudanteRecordDto (@NotBlank String name, @NotNull BigDecimal value) {
}
