package com.example.springboot.serie.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record SerieRecordDto(@NotBlank String name, @NotNull BigDecimal value) {
}
