package com.grupo4.integrador.security;

import com.grupo4.integrador.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private LoginSuccessHandler loginSuccessHandler;
    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/signup").permitAll().and().authorizeRequests()
                .antMatchers("/user/**").hasRole("USER")
                .antMatchers("/odontologo").hasAnyRole("USER", "ADMIN")
                .antMatchers("/paciente/registrar").hasRole("USER")
                .antMatchers("/paciente/buscar").hasRole("USER")
                .antMatchers("/odontologo/buscar").hasRole("USER")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated().and().formLogin().successHandler(loginSuccessHandler).and()
                .logout().deleteCookies("JSESSIONID");
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(usuarioService);
        return provider;
    }

}
