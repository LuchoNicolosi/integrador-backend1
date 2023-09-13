package com.grupo4.integrador.dto.DomicilioDto;

import javax.validation.constraints.NotNull;
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

    public CrearDomicilioDto(String calle, String numero, String localidad, String provincia) {
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }
}
