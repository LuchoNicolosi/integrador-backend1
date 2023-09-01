package com.grupo4.integrador.service;

import com.grupo4.integrador.dto.TurnoDto.ActualizarTurnoDto;
import com.grupo4.integrador.dto.TurnoDto.CrearTurnoDto;
import com.grupo4.integrador.entity.Odontologo;
import com.grupo4.integrador.entity.Paciente;
import com.grupo4.integrador.entity.Turno;
import com.grupo4.integrador.exceptions.ResourceNotFoundException;
import com.grupo4.integrador.repository.OdontologoRepository;
import com.grupo4.integrador.repository.PacienteRepository;
import com.grupo4.integrador.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Turno buscar(Long id) throws ResourceNotFoundException {
        Optional<Turno> t = turnoRepository.findById(id);
        if (t.isEmpty()) {
            throw new ResourceNotFoundException("No existe un turno con el id " + id);
        }
        return t.get();
    }

    public void eliminar(Long id) throws ResourceNotFoundException {
        Turno t = buscar(id);
        turnoRepository.delete(t);
    }

    public Turno modificar(ActualizarTurnoDto turno) throws Exception {
        Optional<Odontologo> odontologo = odontologoIRepository.findById(turno.getOdontologoId());
        Optional<Paciente> paciente = pacienteIRepository.findById(turno.getPacienteId());

        if (paciente.isEmpty() || odontologo.isEmpty()) throw new ResourceNotFoundException("Error a encontrar usuarios.");

        Turno actualizarTurno = new Turno();
        actualizarTurno.setId(turno.getId());
        actualizarTurno.setOdontologo(odontologo.get());
        actualizarTurno.setPaciente(paciente.get());
        actualizarTurno.setFecha(turno.getFecha());

        return turnoRepository.save(actualizarTurno);
    }
}
