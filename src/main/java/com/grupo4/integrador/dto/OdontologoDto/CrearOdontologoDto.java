package com.grupo4.integrador.dto.OdontologoDto;

import com.grupo4.integrador.entidades.Usuario;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(callSuper = true)
@Getter
public class CrearOdontologoDto extends Usuario {
    private String matricula;
}
