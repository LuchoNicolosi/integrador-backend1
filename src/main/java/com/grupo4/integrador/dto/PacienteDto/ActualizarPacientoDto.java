package com.grupo4.integrador.dto.PacienteDto;

import com.grupo4.integrador.dto.DomicilioDto.DomicilioDto;
import com.grupo4.integrador.entity.Domicilio;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Data
public class ActualizarPacientoDto {
    private Long id;
    @NotNull
    private String nombre;
    @NotNull
    private String apellido;
    @NotNull
    private String dni;
    @NotNull
    private LocalDate fechaAlta;
    @NotNull
    private DomicilioDto domicilio;
}
