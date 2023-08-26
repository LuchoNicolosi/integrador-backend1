package com.grupo4.integrador.dto.PacienteDto;

import com.grupo4.integrador.entidades.Domicilio;
import com.grupo4.integrador.entidades.Usuario;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(callSuper = true)
@Getter
public class CrearPacienteDto extends Usuario {
    private String dni;
    private String fechaAlta;
}
