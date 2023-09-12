package com.grupo4.integrador.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UsuarioControlador {
    @GetMapping("/user")
    public String user() {
        return "./usuario/index.html";
    }

    @GetMapping("/admin")
    public String admin() {
        return "./admin/index.html";
    }
}
