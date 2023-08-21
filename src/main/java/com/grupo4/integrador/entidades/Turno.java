package com.grupo4.integrador.entidades;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Turno {
    private int id;
    private int pacienteId;
    private int odontologoId;
    private String fechaHora;

    public Turno(int id, int pacienteId, int odontologoId, String fechaHora) {
        this.id = id;
        this.pacienteId = pacienteId;
        this.odontologoId = odontologoId;
        this.fechaHora = fechaHora;
    }


}
