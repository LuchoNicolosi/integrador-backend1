package com.grupo4.integrador.entidades;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@ToString
public class Paciente extends Usuario {
    private String dni;
    private String fechaAlta;

    public Paciente() {
        super();
    }

    public Paciente(int id, String nombre, String apellido, String dni, String fechaAlta) {
        super(id, nombre, apellido);
        this.dni = dni;
        this.fechaAlta = fechaAlta;
    }

}
