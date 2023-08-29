package com.grupo4.integrador.servicios;

import com.grupo4.integrador.dto.OdontologoDto.CrearOdontologoDto;
import com.grupo4.integrador.entidades.Odontologo;
import com.grupo4.integrador.repositorio.OdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdontologoService {
    private final OdontologoRepository odontologoRepository;

    @Autowired
    public OdontologoService(OdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

//    public Odontologo registrar(CrearOdontologoDto o) {
//        Odontologo odontologo = new Odontologo();
//        if (o != null) {
//            odontologo.setNombre(o.getNombre());
//            odontologo.setApellido(o.getApellido());
//            odontologo.setMatricula(o.getMatricula());
//        }
//        return odontologoRepository.registrar(odontologo);
//    }
//
//    public List<Odontologo> listar() {
//        return odontologoRepository.listar();
//    }
//
//    public Odontologo buscar(int id) {
//        return odontologoRepository.buscar(id);
//    }
//
//    public void eliminar(int id) {
//        odontologoRepository.eliminar(id);
//    }

}
