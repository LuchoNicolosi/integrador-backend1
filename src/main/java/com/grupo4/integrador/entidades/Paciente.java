package com.grupo4.integrador.entidades;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class Paciente extends Usuario{
    private String domicilio;
    private String dni;
    private LocalDate fechaAlta;

    public Paciente(int id, String nombre, String apellido, String domicilio, String dni, LocalDate fehcaAlta){
        super(id,nombre,apellido);
        this.domicilio = domicilio;
        this.dni = dni;
        this.fechaAlta = fehcaAlta;
    }

}
