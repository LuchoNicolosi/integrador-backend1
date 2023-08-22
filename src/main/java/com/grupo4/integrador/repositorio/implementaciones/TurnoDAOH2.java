package com.grupo4.integrador.repositorio.implementaciones;

import com.grupo4.integrador.repositorio.IDao;
import com.grupo4.integrador.entidades.Turno;
import com.grupo4.integrador.utilidades.Query;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static com.grupo4.integrador.repositorio.implementaciones.db.getConnection;

@Repository
public class TurnoDAOH2 implements IDao<Turno> {
    private final static Logger LOGGER = Logger.getLogger(TurnoDAOH2.class);
    private Integer autoIncrementId = 0;
    @Override
    public Turno registrar(Turno turno) {
        Turno tur = null;
        //TODO arreglar el tema del DATE, por que lo almacene como STRING
        try (PreparedStatement pst = getConnection().prepareStatement(Query.INSERT_VALUE_TURNO)) {
            pst.setInt(1, turno.getPacienteId());
            pst.setInt(2, turno.getOdontologoId());
            pst.setString(3, turno.getFechaHora());
            pst.execute();
            tur = turno;
            tur.setId(autoIncrementId += 1);
            LOGGER.info("se registro un turno!");

        } catch (Exception e) {
            LOGGER.error("Error al registrar el turno!\n" + e);
        }
        return tur;
    }

    @Override
    public List<Turno> listar() {
        List<Turno> turnos = new ArrayList<>();
        try (PreparedStatement pst = getConnection().prepareStatement("SELECT * FROM PACIENTE")) {
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                turnos.add(new Turno(rs.getInt("ID"), rs.getInt(2), rs.getInt(3), rs.getString(4)));
            }
            LOGGER.info(turnos);
        } catch (Exception e) {
            LOGGER.error("error al listar los odontologos");
            return new ArrayList<>();
        }
        return turnos;
    }

}

