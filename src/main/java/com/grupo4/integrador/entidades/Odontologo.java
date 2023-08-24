package com.grupo4.integrador.entidades;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Odontologo extends Usuario {

    private String nMatricula;

    public Odontologo() {
        super();
    }

    public Odontologo(int id, String nombre, String apellido, String nMatricula) {
        super(id, nombre, apellido);
        this.nMatricula = nMatricula;
    }

}
