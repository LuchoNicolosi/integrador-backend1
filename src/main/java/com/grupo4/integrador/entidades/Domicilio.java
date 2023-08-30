package com.grupo4.integrador.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "domicilios")
@Data
public class Domicilio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String calle;
    private String numero;
    private String localidad;
    private String provincia;

    @OneToOne(mappedBy = "domicilio")
    @JsonIgnore
    private Paciente paciente;

    public Domicilio() {

    }

    public Domicilio(Paciente paciente, String calle, String numero, String localidad, String provincia) {
        this.paciente = paciente;
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }
}
