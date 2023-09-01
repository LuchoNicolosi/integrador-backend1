package com.grupo4.integrador.dto.OdontologoDto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class CrearOdontologoDto {
    private int id;
    @NotNull
    private String nombre;
    @NotNull
    private String apellido;
    @NotNull
    private String matricula;

}
