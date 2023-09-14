package com.grupo4.integrador.dto.DomicilioDto;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.Getter;

@Data
public class CrearDomicilioDto {
    @NotNull
    private String calle;
    @NotNull
    private String numero;
    @NotNull
    private String localidad;
    @NotNull
    private String provincia;

}
