package com.grupo4.integrador.dto.TurnoDto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class CrearTurnoDto {
    @NotNull
    private Long odontologoId;
    @NotNull
    private Long pacienteId;
    @NotNull
    private String fecha;
}
