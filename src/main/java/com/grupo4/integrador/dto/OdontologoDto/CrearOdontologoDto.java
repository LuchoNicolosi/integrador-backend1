package com.grupo4.integrador.dto.OdontologoDto;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import lombok.Data;


@Data
public class CrearOdontologoDto {
    @NotNull
    private String nombre;
    @NotNull
    private String apellido;
    @NotNull
    private String matricula;

}
