package com.grupo4.integrador.repositorio.implementaciones;

import com.grupo4.integrador.entidades.Odontologo;
import com.grupo4.integrador.entidades.Paciente;
import com.grupo4.integrador.repositorio.IRepository;
import com.grupo4.integrador.entidades.Turno;
import com.grupo4.integrador.utilidades.Query;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static com.grupo4.integrador.repositorio.implementaciones.db.getConnection;

@Repository
public class TurnoRepository implements IRepository<Turno> {
    private final static Logger LOGGER = Logger.getLogger(TurnoRepository.class);
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
        return null;
    }

    @Override
    public Turno buscar(int id) {
        return null;
    }

    @Override
    public void eliminar(int id) {
    }

    @Override
    public Turno modificar(Turno turno) {
        return null;
    }


}

