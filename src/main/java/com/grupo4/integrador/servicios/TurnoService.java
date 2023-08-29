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

//    public Turno registrar(CrearTurnoDto turno) throws Exception {
//        Turno nuevoTurno = new Turno();
//        Paciente paciente = pacienteIRepository.buscar(turno.getPacienteId());
//        Odontologo odontologo = odontologoIRepository.buscar(turno.getOdontologoId());
//
//        if (paciente == null) throw new Exception("No se encontro el paciente");
//        if (odontologo == null) throw new Exception("No se encontro el odontologo");
//
//        nuevoTurno.setPaciente(paciente);
//        nuevoTurno.setOdontologo(odontologo);
//        nuevoTurno.setFecha(turno.getFecha());
//
//        return turnoRepository.registrar(nuevoTurno);
//    }
//
//    public List<Turno> listar() {
//        return turnoRepository.listar();
//    }
//    public void eliminarTurno(int id){
//        turnoRepository.eliminar(id);
//    }
//    public Turno buscarTurno(int id){
//        return turnoRepository.buscar(id);
//    }
//
//    public Turno modificar(Turno turno) {
//        return turnoRepository.modificar(turno);
//    }
}
