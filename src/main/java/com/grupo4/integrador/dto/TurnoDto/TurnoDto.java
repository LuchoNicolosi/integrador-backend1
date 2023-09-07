package com.grupo4.integrador.dto.TurnoDto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.grupo4.integrador.dto.OdontologoDto.OdontologoDto;
import com.grupo4.integrador.dto.PacienteDto.PacienteDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
public class TurnoDto {
    private Long id;
    private OdontologoDto odontologo;
    private PacienteDto paciente;
    @JsonAlias({"date"})
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime fecha;
}
