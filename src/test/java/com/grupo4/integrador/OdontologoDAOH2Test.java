package com.grupo4.integrador;

import com.grupo4.integrador.daos.implementaciones.OdontologoDAOH2;
import com.grupo4.integrador.entidades.Odontologo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.grupo4.integrador.servicios.OdontologoService;

import static org.junit.jupiter.api.Assertions.*;

public class OdontologoDAOH2Test {

    Odontologo od = new Odontologo(1, "abc-1234", "Leonardo", "Spadavecchia");
    Odontologo od2 = new Odontologo(2, "abc-12345", "Luciano", "sdasas");
    Odontologo od3 = new Odontologo(3, "abc-123456", "Pepo", "sdasda");
    Odontologo od4 = new Odontologo(4, "abc-1234567", "Pepa", "as");
    OdontologoService os = new OdontologoService(new OdontologoDAOH2());

    @BeforeEach
    public void crearTablas() {
        OdontologoDAOH2.crearTablaOdontologo();
    }

    @Test
    public void registrar() {
        assertEquals(true, os.registrar(od));
    }

    @Test
    public void listar() {
        os.registrar(od);
        os.registrar(od2);
        os.registrar(od3);
        os.registrar(od4);
        assertEquals(4, os.listar().size());
    }
}