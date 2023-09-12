package com.grupo4.integrador.dto.OdontologoDto;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ActualizarOdontologoDto {
    private Long id;
    @NotNull
    private String nombre;
    @NotNull
    private String apellido;
    @NotNull
    private String matricula;
}
