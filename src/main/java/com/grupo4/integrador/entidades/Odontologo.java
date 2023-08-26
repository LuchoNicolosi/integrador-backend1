package com.grupo4.integrador.entidades;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Odontologo extends Usuario {

    private String matricula;

    public Odontologo() {
        super();
    }

    public Odontologo(int id, String nombre, String apellido, String matricula) {
        super(id, nombre, apellido);
        this.matricula = matricula;
    }

}
