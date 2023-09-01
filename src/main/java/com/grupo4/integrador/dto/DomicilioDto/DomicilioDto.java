package com.grupo4.integrador.dto.DomicilioDto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DomicilioDto {
    private Integer id;
    private String calle;
    private String numero;
    private String localidad;
    private String provincia;
}
