package com.grupo4.integrador.servicios;

import com.grupo4.integrador.dto.CrearTurnoDTO;
import com.grupo4.integrador.entidades.Odontologo;
import com.grupo4.integrador.entidades.Paciente;
import com.grupo4.integrador.repositorio.IRepository;
import com.grupo4.integrador.entidades.Turno;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoService {
    private final IRepository<Turno> turnoRepository;
    private final IRepository<Paciente> pacienteIRepository;
    private final IRepository<Odontologo> odontologoIRepository;

    public TurnoService(IRepository<Turno> turnoRepository, IRepository<Paciente> pacienteIRepository, IRepository<Odontologo> odontologoIRepository) {
        this.turnoRepository = turnoRepository;
        this.pacienteIRepository = pacienteIRepository;
        this.odontologoIRepository = odontologoIRepository;
    }

    public Turno registrar(CrearTurnoDTO turno) throws Exception {
        Turno nuevoTurno = new Turno();
        Paciente paciente = pacienteIRepository.buscar(turno.getPacienteId());
        Odontologo odontologo = odontologoIRepository.buscar(turno.getOdontologoId());

        if (paciente == null) throw new Exception("No se encontro el paciente");
        if (odontologo == null) throw new Exception("No se encontro el odontologo");

        nuevoTurno.setPaciente(paciente);
        nuevoTurno.setOdontologo(odontologo);
        nuevoTurno.setFecha(turno.getFecha());

        return turnoRepository.registrar(nuevoTurno);
    }

    public List<Turno> listar() {
        return turnoRepository.listar();
    }

    public Turno modificar(Turno turno) {
        return turnoRepository.modificar(turno);
    }
}
