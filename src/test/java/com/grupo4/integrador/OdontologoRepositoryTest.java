package com.grupo4.integrador;

import com.grupo4.integrador.repositorio.implementaciones.OdontologoRepository;
import com.grupo4.integrador.entidades.Odontologo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.grupo4.integrador.entidades.servicios.OdontologoService;

public class OdontologoRepositoryTest {

    Odontologo od = new Odontologo(1, "abc-1234", "Leonardo", "Spadavecchia");
    Odontologo od2 = new Odontologo(2, "abc-12345", "Luciano", "sdasas");
    Odontologo od3 = new Odontologo(3, "abc-123456", "Pepo", "sdasda");
    Odontologo od4 = new Odontologo(4, "abc-1234567", "Pepa", "as");
    OdontologoService os = new OdontologoService(new OdontologoRepository());


    @Test
    public void registrar() {
        Assertions.assertNotNull(os.registrar(od));
    }

    @Test
    public void listar() {
        os.registrar(od);
        os.registrar(od2);
        os.registrar(od3);
        os.registrar(od4);
        Assertions.assertEquals(4, os.listar().size());
    }
}