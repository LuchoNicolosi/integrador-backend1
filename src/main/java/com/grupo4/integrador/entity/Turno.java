package com.grupo4.integrador.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "turnos")
@Data
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false)
    private LocalDate fecha;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "odontologo_id", nullable = false)
    private Odontologo odontologo;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    public Turno() {

    }

    public Turno(Odontologo odontologo, Paciente paciente, LocalDate fecha) {
        this.odontologo = odontologo;
        this.paciente = paciente;
        this.fecha = fecha;
    }
}
