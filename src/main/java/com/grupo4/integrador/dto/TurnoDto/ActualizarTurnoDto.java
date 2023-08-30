package com.grupo4.integrador.dto.TurnoDto;

import com.grupo4.integrador.dto.OdontologoDto.OdontologoDto;
import com.grupo4.integrador.dto.PacienteDto.PacienteDto;
import com.grupo4.integrador.entidades.Odontologo;
import com.grupo4.integrador.entidades.Paciente;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ActualizarTurnoDto {
    private Long id;
    private Long odontologoId;
    private Long pacienteId;
    private String fecha;
}
