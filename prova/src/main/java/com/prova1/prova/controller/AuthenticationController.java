package com.prova1.prova.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prova1.prova.dto.LoginResponse;
import com.prova1.prova.dto.request.LoginRequest;
import com.prova1.prova.model.Usuario;
import com.prova1.prova.service.JwtTokenService;

@Controller
@RequestMapping("/auth")
public class AuthenticationController {

    public final AuthenticationManager manager;
    public final JwtTokenService jwtTokenService;

    public AuthenticationController(AuthenticationManager manager, JwtTokenService tokenService){
        this.manager = manager;
        this.jwtTokenService = tokenService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest data){
        var token = new UsernamePasswordAuthenticationToken(data.username(), data.password());
        var authentication = manager.authenticate(token);
        var jwtToken = this.jwtTokenService.gerarToken((Usuario) authentication.getPrincipal());

        return ResponseEntity.ok().body(new LoginResponse(jwtToken));
    }
}
