package com.grupo4.integrador.entidades;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Turno {
    private int id;
    private Odontologo odontologo;
    private Paciente paciente;
    private String fecha;

    public Turno(){

    }
    public Turno(int id, Odontologo odontologo, Paciente paciente, String fecha) {
        this.id = id;
        this.odontologo = odontologo;
        this.paciente = paciente;
        this.fecha = fecha;
    }
}
