package com.grupo4.integrador.repositorio.implementaciones;

import com.grupo4.integrador.entidades.Odontologo;
import com.grupo4.integrador.entidades.Paciente;
import com.grupo4.integrador.repositorio.IRepository;
import com.grupo4.integrador.entidades.Turno;
import com.grupo4.integrador.utilidades.Query;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static com.grupo4.integrador.repositorio.implementaciones.db.getConnection;

@Repository
public class TurnoRepository implements IRepository<Turno> {
    private final static Logger LOGGER = Logger.getLogger(TurnoRepository.class);
    @Autowired
    private IRepository<Odontologo> odontologoIRepository;
    @Autowired
    private IRepository<Paciente> pacienteIRepository;
    private Integer autoIncrementId = 0;

    @Override
    public Turno registrar(Turno turno) {
        Turno tur = turno;
        //TODO arreglar el tema del DATE, por que lo almacene como STRING
        try (PreparedStatement pst = getConnection().prepareStatement(Query.INSERT_VALUE_TURNO)) {
            pst.setInt(1, turno.getPaciente().getId());
            pst.setInt(2, turno.getOdontologo().getId());
            pst.setString(3, turno.getFecha());
            pst.execute();
            tur.setId(autoIncrementId += 1);
            LOGGER.info("se registro un turno!");

        } catch (Exception e) {
            LOGGER.error("Error al registrar el turno!\n" + e);
        }
        return tur;
    }

    @Override
    public List<Turno> listar() {
        List<Turno> turnoList = new ArrayList<>();
        try(PreparedStatement pst = db.getConnection().prepareStatement(Query.LISTAR_TURNOS)){
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                turnoList.add(new Turno(rs.getInt(1),odontologoIRepository.buscar(rs.getInt(2)),pacienteIRepository.buscar(rs.getInt(3)),rs.getString(4)));
            }
            LOGGER.info("se encontrarons los siguientes turnos: " + turnoList);
        }catch(Exception e){
            LOGGER.error("error al listar los turnos", e);
        }
        return turnoList;
    }

    @Override
    public Turno buscar(int id) {
        Turno turno = null;
        try(PreparedStatement pst = getConnection().prepareStatement(Query.BUSCAR_TURNO)){
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                turno = new Turno(rs.getInt(1), odontologoIRepository.buscar(id), pacienteIRepository.buscar(id),rs.getString(4));
                     }
            LOGGER.info("se encontro el siguiente turno: " + turno);
        }catch(Exception e){
            LOGGER.error("no se encontro el turno con id " + id);
        }
        return turno;
    }

    @Override
    public void eliminar(int id) {
        if (buscar(id) != null) {
            try (PreparedStatement pst = getConnection().prepareStatement(Query.DELETE_TURNO)) {
                pst.setInt(1, id);
                pst.execute();
                LOGGER.info("TURNO eliminado - ID >" + id);
            } catch (Exception e) {
                LOGGER.error("Error eliminando el TURNO.");
            }
        }
    }

    @Override
    public Turno modificar(Turno turno) {
        return null;
    }


}

