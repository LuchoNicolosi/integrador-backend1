package com.grupo4.integrador.dto.PacienteDto;

import com.grupo4.integrador.entidades.Domicilio;
import com.grupo4.integrador.entidades.Usuario;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class PacienteDto extends Usuario {
    private String dni;
    private String fechaAlta;
}
