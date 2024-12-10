package com.biblioteca.biblioteca.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.biblioteca.biblioteca.dto.TokenDTO;
import com.biblioteca.biblioteca.dto.request.LoginRequest;
import com.biblioteca.biblioteca.model.Usuario;
import com.biblioteca.biblioteca.service.JwtTokenService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationManager manager;
    private final JwtTokenService jwtTokenService;

    @PostMapping("/login")
    public ResponseEntity<TokenDTO> logar(@RequestBody @Valid LoginRequest dados){
        var token = new UsernamePasswordAuthenticationToken(dados.username(), dados.password());
        var authetication = this.manager.authenticate(token);

        var jwtToken = this.jwtTokenService.gerarToken((Usuario) authetication.getPrincipal());

        return ResponseEntity.ok().body(new TokenDTO(jwtToken));
    }
}
