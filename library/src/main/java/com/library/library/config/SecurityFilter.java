package com.library.library.config;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.library.library.repository.UsuarioRepository;
import com.library.library.service.security.JwtTokenService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class SecurityFilter extends OncePerRequestFilter {

    private final JwtTokenService jwtTokenService;
    private final UsuarioRepository usuarioRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        var token = this.validToken(request);

        if(token != null){
            var login = this.jwtTokenService.validToken(token);
            var usuario = this.usuarioRepository.findByUsername(login);
            var authenticated = new UsernamePasswordAuthenticationToken(response, null, usuario.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authenticated);
        }
        
        filterChain.doFilter(request, response);
    }


    private String validToken(HttpServletRequest request){
        var token = request.getHeader("Authorization");

        if(token == null || token.isEmpty() || !token.startsWith("Bearer ")){
            return null;
        }

        return token.replace("Bearer ", "");
    }
    

}
