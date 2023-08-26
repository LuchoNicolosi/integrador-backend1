package com.grupo4.integrador.repositorio.implementaciones;

import com.grupo4.integrador.entidades.Domicilio;
import com.grupo4.integrador.repositorio.IRepository;
import com.grupo4.integrador.utilidades.Query;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static com.grupo4.integrador.repositorio.implementaciones.db.getConnection;

@Repository
public class DomicilioRepository implements IRepository<Domicilio> {
    private final static Logger LOGGER = Logger.getLogger(DomicilioRepository.class);

    private final PacienteRepository pacienteRepository;
    private Integer autoIncrementId = 0;

    public DomicilioRepository(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public Domicilio registrar(Domicilio domicilio) {
        Domicilio dom = null;
        try (PreparedStatement pst = db.getConnection().prepareStatement(Query.INSERT_VALUE_DOMICILIO)) {
            pst.setInt(1, domicilio.getPaciente().getId());
            pst.setString(2, domicilio.getCalle());
            pst.setString(3, domicilio.getNumero());
            pst.setString(4, domicilio.getLocalidad());
            pst.setString(5, domicilio.getProvincia());
            pst.execute();
            LOGGER.info("SE REGISTRO UN DOMICILIO!");
            dom = domicilio;
            dom.setId(autoIncrementId += 1);
        } catch (Exception e) {
            LOGGER.error("algo salio mal", e);
        }
        return dom;
    }

    @Override
    public List<Domicilio> listar() {
        List<Domicilio> domicilios = new ArrayList<>();
        try (PreparedStatement pst = db.getConnection().prepareStatement(Query.LISTAR_DOMICILIO)) {
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                domicilios.add(new Domicilio(rs.getInt("ID"), pacienteRepository.buscar(rs.getInt("PACIENTE_ID")), rs.getString("CALLE"), rs.getString("NUMERO"), rs.getString("LOCALIDAD"), rs.getString("PROVINCIA")));
            }
        } catch (Exception e) {
            LOGGER.error("error al listar los pacientes");
            return new ArrayList<>();
        }
        LOGGER.info("Lista de domicilios :" + domicilios);
        return domicilios;
    }

    @Override
    public Domicilio buscar(int paciente_id) {
        Domicilio domicilio = null;
        try (PreparedStatement pst = getConnection().prepareStatement(Query.BUSCAR_DOMICILIO)) {
            pst.setInt(1, paciente_id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                domicilio = new Domicilio(rs.getInt("ID"), pacienteRepository.buscar(paciente_id), rs.getString("CALLE"), rs.getString("NUMERO"), rs.getString("LOCALIDAD"), rs.getString("PROVINCIA"));
            }
            LOGGER.info("DomicilioId: " + domicilio.getId());
        } catch (Exception e) {
            LOGGER.error("Paciente no encontrado." + e);
        }
        return domicilio;
    }


    @Override
    public void eliminar(int paciente_id) {
        if (buscar(paciente_id) != null) {
            try (PreparedStatement pst = getConnection().prepareStatement(Query.DELETE_DOMICILIO)) {
                pst.setInt(1, paciente_id);
                pst.execute();
                LOGGER.info("Domicilio eliminado - paciente_id = " + paciente_id);
            } catch (Exception e) {
                LOGGER.error("Error eliminando el Domicilio.");
            }
        }
    }

    @Override
    public Domicilio modificar(Domicilio d) {
        return null;
    }
}
