package com.grupo4.integrador.daos.implementaciones;

import com.grupo4.integrador.daos.IDao;
import com.grupo4.integrador.entidades.Turno;
import com.grupo4.integrador.utilidades.Query;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static com.grupo4.integrador.daos.implementaciones.db.getConnection;

public class TurnoDAOH2 implements IDao<Turno> {
    private final static Logger LOGGER = Logger.getLogger(TurnoDAOH2.class);

    public static void crearTablaTurno() {
        try (Statement stm = getConnection().createStatement();) {
            stm.execute(Query.CREATE_TABLE_TURNO);
            LOGGER.info("Tabla turno creada con exito!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Turno registrar(Turno turno) {
        Turno tur = null;
        //TODO arreglar el tema del DATE, por que lo almacene como STRING
        try (PreparedStatement pst = getConnection().prepareStatement(Query.INSERT_VALUE_TURNO)) {
            pst.setInt(1, turno.getId());
            pst.setInt(2, turno.getPacienteId());
            pst.setInt(3, turno.getOdontologoId());
            pst.setString(4, turno.getFechaHora());
            pst.execute();
            tur = turno;
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
}
