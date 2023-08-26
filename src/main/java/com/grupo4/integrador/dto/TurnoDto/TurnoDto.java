package com.grupo4.integrador.dto.TurnoDto;

import com.grupo4.integrador.entidades.Odontologo;
import com.grupo4.integrador.entidades.Paciente;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TurnoDto {
    private int id;
    private Odontologo odontologo;
    private Paciente paciente;
    private String fecha;
}
