package com.grupo4.integrador.dto.PacienteDto;

import com.grupo4.integrador.dto.DomicilioDto.CrearDomicilioDto;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class CrearPacienteDto {
    @NotNull
    private String nombre;
    @NotNull
    private String apellido;
    @NotNull
    private String dni;
    @NotNull
    private String fechaAlta;
    @NotNull
    private CrearDomicilioDto domicilio;
}
