package com.grupo4.integrador.dto.PacienteDto;

import com.grupo4.integrador.dto.DomicilioDto.DomicilioDto;
import com.grupo4.integrador.entity.Domicilio;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String fechaAlta;
    @NotNull
    private DomicilioDto domicilio;
}
