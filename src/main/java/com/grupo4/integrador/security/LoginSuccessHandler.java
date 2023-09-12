package com.grupo4.integrador.security;

import com.grupo4.integrador.entity.Usuario;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws ServletException, IOException {

        Usuario userDetails = (Usuario) authentication.getPrincipal();

        String redirectURL = request.getContextPath();

        if (userDetails.getRol().name().equals("ROLE_USER")) {
            redirectURL = "user";
        } else if (userDetails.getRol().name().equals("ROLE_ADMIN")) {
            redirectURL = "admin";
        }
        response.sendRedirect(redirectURL);

    }
}
