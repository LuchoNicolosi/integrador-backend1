package com.grupo4.integrador.dto.TurnoDto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ActualizarTurnoDto {
    private Long id;
    @NotNull
    private Long odontologoId;
    @NotNull
    private Long pacienteId;
    @NotNull
    private String fecha;
}
