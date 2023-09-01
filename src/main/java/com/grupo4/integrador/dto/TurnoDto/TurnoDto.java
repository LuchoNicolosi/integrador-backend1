package com.grupo4.integrador.dto.TurnoDto;

import com.grupo4.integrador.dto.OdontologoDto.OdontologoDto;
import com.grupo4.integrador.dto.PacienteDto.PacienteDto;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TurnoDto {
    private Long id;
    private OdontologoDto odontologo;
    private PacienteDto paciente;
    private String fecha;
}
