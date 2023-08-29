package com.grupo4.integrador.dto.OdontologoDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class OdontologoDto {
    private int id;
    private String nombre;
    private String apellido;
    //  private String matricula;
}
