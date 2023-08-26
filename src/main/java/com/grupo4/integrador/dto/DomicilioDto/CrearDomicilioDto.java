package com.grupo4.integrador.dto.DomicilioDto;

import lombok.Getter;

@Getter
public class CrearDomicilioDto {
    private int paciente_id;
    private String calle;
    private String numero;
    private String localidad;
    private String provincia;
}
