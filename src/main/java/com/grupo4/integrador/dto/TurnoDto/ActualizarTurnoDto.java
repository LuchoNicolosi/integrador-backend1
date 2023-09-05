package com.grupo4.integrador.dto.TurnoDto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class ActualizarTurnoDto {
    private Long id;
    @NotNull
    private Long odontologoId;
    @NotNull
    private Long pacienteId;
    @JsonAlias({"date"})
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull
    private LocalDate fecha;
}
