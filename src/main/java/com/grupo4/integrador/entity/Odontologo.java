package com.grupo4.integrador.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "odontologos")
@Data
public class Odontologo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String apellido;
//    @Column(nullable = false)
    private String matricula;
    @OneToMany(mappedBy = "odontologo")
    @JsonIgnore
    private List<Turno> turnos;

    public Odontologo() {

    }

    public Odontologo(String nombre, String apellido, String matricula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
        this.turnos = new ArrayList<>();
    }
}
