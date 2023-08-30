package com.grupo4.integrador.dto.PacienteDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.grupo4.integrador.dto.DomicilioDto.DomicilioDto;
import com.grupo4.integrador.entidades.Domicilio;
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
    private Domicilio domicilio;
}
