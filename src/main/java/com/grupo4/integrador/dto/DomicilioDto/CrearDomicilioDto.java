package com.grupo4.integrador.dto.DomicilioDto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
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
