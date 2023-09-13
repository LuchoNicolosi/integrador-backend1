package com.grupo4.integrador.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthController {
    @GetMapping("/signup")
    public String signup() {
        return "./auth/signup.html";
    }
}
