package com.grupo4.integrador.service;

import com.grupo4.integrador.dto.OdontologoDto.ActualizarOdontologoDto;
import com.grupo4.integrador.dto.OdontologoDto.CrearOdontologoDto;
import com.grupo4.integrador.entity.Odontologo;
import com.grupo4.integrador.exceptions.BadRequestException;
import com.grupo4.integrador.exceptions.ResourceNotFoundException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Transactional
class OdontologoServiceTest {

    @Autowired
    private OdontologoService odontologoService;

    @BeforeEach
    public void cargarData() throws BadRequestException {
        CrearOdontologoDto odontologo = new CrearOdontologoDto();
        odontologo.setNombre("leo");
        odontologo.setApellido("messi");
        odontologo.setMatricula("abc-1234");

        odontologoService.registrar(odontologo);
    }

    @Test
    void listar() {
        List<Odontologo> odontologoList = odontologoService.listar();
        Assert.assertFalse(odontologoList.isEmpty());
    }

    @Test
    void buscar() {
        Assert.assertNotNull(odontologoService.buscar(1L));
    }

    @Test
    void actualizar() {
        ActualizarOdontologoDto od = new ActualizarOdontologoDto();
        od.setId(1L);
        od.setNombre("carlitos");
        od.setApellido("tevez");
        od.setMatricula("az-12");
        Assert.assertNotNull(odontologoService.actualizarOdontologo(od));
    }

    @Test
    void eliminar() {
        try {
            odontologoService.eliminar(1L);
            Assert.fail();
        } catch (Exception e) {
            Assert.assertEquals(ResourceNotFoundException.class, e.getClass());
        }
    }
}