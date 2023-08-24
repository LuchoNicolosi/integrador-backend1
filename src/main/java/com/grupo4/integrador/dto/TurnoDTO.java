package com.grupo4.integrador.dto;

import com.grupo4.integrador.entidades.Odontologo;
import com.grupo4.integrador.entidades.Paciente;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TurnoDTO {
    private int id;
    private Odontologo odontologo;
    private Paciente paciente;
    private String fecha;
}
