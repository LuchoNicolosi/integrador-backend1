package com.grupo4.integrador.servicios;

import com.grupo4.integrador.dto.TurnoDto.CrearTurnoDto;
import com.grupo4.integrador.entidades.Odontologo;
import com.grupo4.integrador.entidades.Paciente;
import com.grupo4.integrador.entidades.Turno;
import com.grupo4.integrador.repositorio.OdontologoRepository;
import com.grupo4.integrador.repositorio.PacienteRepository;
import com.grupo4.integrador.repositorio.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

@Service
public class TurnoService {
    private final TurnoRepository turnoRepository;
    private final PacienteRepository pacienteIRepository;
    private final OdontologoRepository odontologoIRepository;

    @Autowired
    public TurnoService(TurnoRepository turnoRepository, PacienteRepository pacienteIRepository, OdontologoRepository odontologoIRepository) {
        this.turnoRepository = turnoRepository;
        this.pacienteIRepository = pacienteIRepository;
        this.odontologoIRepository = odontologoIRepository;
    }

    public Turno registrar(CrearTurnoDto turno) throws Exception {
        Turno nuevoTurno = new Turno();
        Optional<Paciente> paciente = pacienteIRepository.findById(turno.getPacienteId());
        Optional<Odontologo> odontologo = odontologoIRepository.findById(turno.getOdontologoId());

        if (paciente.isEmpty()) throw new Exception("Paciente no encontrado");
        if (odontologo.isEmpty()) throw new Exception("Odontologo no encontrado");

        nuevoTurno.setPaciente(paciente.get());
        nuevoTurno.setOdontologo(odontologo.get());
        nuevoTurno.setFecha(turno.getFecha());
        return turnoRepository.save(nuevoTurno);
    }

    public List<Turno> listar() {
        return turnoRepository.findAll();
    }

    public Turno buscar(Long id) {
        Optional<Turno> o = turnoRepository.findById(id);
        return o.orElse(null);
    }

    public void eliminar(Long id) {
        Optional<Turno> o = turnoRepository.findById(id);
        o.ifPresent(turnoRepository::delete);
    }

    public Turno modificar(CrearTurnoDto turno) throws Exception {
        return registrar(turno);
    }
}
