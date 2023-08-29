package com.grupo4.integrador.dto.PacienteDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PacienteDto {
    private int id;
    private String nombre;
    private String apellido;
    // private String dni;
    private String fechaAlta;
}
