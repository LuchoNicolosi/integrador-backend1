package com.grupo4.integrador.dto.DomicilioDto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DomicilioDto {
    private Long id;
    private String calle;
    private String numero;
    private String localidad;
    private String provincia;

    public DomicilioDto(Long id, String calle, String numero, String localidad, String provincia) {
        this.id = id;
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }
}
