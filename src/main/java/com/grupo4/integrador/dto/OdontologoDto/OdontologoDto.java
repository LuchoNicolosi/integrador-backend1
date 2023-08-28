package com.grupo4.integrador.dto.OdontologoDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.grupo4.integrador.entidades.Usuario;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class OdontologoDto extends Usuario {
  //  private String matricula;
}
