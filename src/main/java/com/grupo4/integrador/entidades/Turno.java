package com.grupo4.integrador.entidades;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "turnos")
@Data
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String fecha;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "odontologo_id", nullable = false)
    private Odontologo odontologo;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paciente_id",nullable = false)
    private Paciente paciente;

    public Turno() {

    }

    public Turno(Odontologo odontologo, Paciente paciente, String fecha) {
        this.odontologo = odontologo;
        this.paciente = paciente;
        this.fecha = fecha;
    }
}
