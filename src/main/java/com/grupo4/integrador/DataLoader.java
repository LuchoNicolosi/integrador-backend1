package com.grupo4.integrador;

import com.grupo4.integrador.entity.Usuario;
import com.grupo4.integrador.entity.UsuarioRoles;
import com.grupo4.integrador.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements ApplicationRunner {
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public DataLoader(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);
        //Credenciales harcodeadas
        //TODO: Signup
        String password = passwordEncoder.encode("user");
        String password2 = passwordEncoder.encode("admin");

        usuarioRepository.save(new Usuario("usuario", "usuario@gmail.com", password, UsuarioRoles.ROLE_USER));
        usuarioRepository.save(new Usuario("admin", "admin@gmail.com", password2, UsuarioRoles.ROLE_ADMIN));
    }
}
