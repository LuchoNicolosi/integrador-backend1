package com.grupo4.integrador.dto.OdontologoDto;

import com.grupo4.integrador.entidades.Usuario;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class OdontologoDto extends Usuario {
    private String matricula;
}
