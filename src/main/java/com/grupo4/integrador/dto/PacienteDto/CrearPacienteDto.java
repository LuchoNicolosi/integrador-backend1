package com.grupo4.integrador.dto.PacienteDto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.grupo4.integrador.dto.DomicilioDto.CrearDomicilioDto;
import javax.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Date;

@Getter
public class CrearPacienteDto {
    @NotNull
    private String nombre;
    @NotNull
    private String apellido;
    @NotNull
    private String dni;

    @JsonAlias({"date"})
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate fechaAlta;
    @NotNull
    private CrearDomicilioDto domicilio;
}
