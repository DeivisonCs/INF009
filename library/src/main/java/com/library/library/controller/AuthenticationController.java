package com.library.library.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.library.library.dto.LoginData;
import com.library.library.dto.TokenResponse;
import com.library.library.model.Usuario;
import com.library.library.service.security.JwtTokenService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthenticationController {

    private AuthenticationManager manager;
    private JwtTokenService jwtTokenService;

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@RequestBody LoginData data){
        var token = new UsernamePasswordAuthenticationToken(data.username(), data.password());
        var authentication = manager.authenticate(token);

        var jwtToken = this.jwtTokenService.generateToken((Usuario) authentication.getPrincipal());

        return ResponseEntity.ok().body(new TokenResponse(jwtToken));
    }
}
