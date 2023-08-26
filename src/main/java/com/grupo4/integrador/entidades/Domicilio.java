package com.grupo4.integrador.entidades;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Domicilio {
    private Integer id;
    private Paciente paciente;
    private String calle;
    private String numero;
    private String localidad;
    private String provincia;

    public Domicilio() {

    }

    public Domicilio(Integer id, Paciente paciente, String calle, String numero, String localidad, String provincia) {
        this.id = id;
        this.paciente = paciente;
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }
}
