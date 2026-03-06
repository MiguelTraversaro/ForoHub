package com.example.ForoHub.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(
        @NotBlank String titulo,
        @NotBlank String mensaje,
        @NotNull Boolean status
) {
}