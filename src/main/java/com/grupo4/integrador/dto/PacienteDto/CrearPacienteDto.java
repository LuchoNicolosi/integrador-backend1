package com.grupo4.integrador.dto.PacienteDto;

import com.grupo4.integrador.dto.DomicilioDto.CrearDomicilioDto;
import lombok.Getter;

@Getter
public class CrearPacienteDto  {
    private String nombre;
    private String apellido;
    private String dni;
    private String fechaAlta;
    private CrearDomicilioDto domicilio;
}
