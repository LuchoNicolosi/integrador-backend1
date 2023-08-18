package com.grupo4.integrador.entidades;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class Turno {
    private int id;
    private Usuario paciente;
    private Usuario odontologo;
    private LocalDateTime fechaHora;

    public Turno(int id, Usuario paciente, Usuario odontologo, LocalDateTime fechaHora){
        this.id = id;
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.fechaHora = fechaHora;
    }
}
