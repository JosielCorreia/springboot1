package com.example.springboot.escola.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record EscolaRecordDto(@NotBlank String name, @NotNull BigDecimal value) {
}
