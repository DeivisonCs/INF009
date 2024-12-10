package com.ecommerce.ecommerce.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecommerce.ecommerce.dto.DadosAutenticacao;
import com.ecommerce.ecommerce.dto.DadosToken;
import com.ecommerce.ecommerce.dto.UserDTO;
import com.ecommerce.ecommerce.dto.request.UserRequest;
import com.ecommerce.ecommerce.model.User;
import com.ecommerce.ecommerce.service.AuthenticationService;
import com.ecommerce.ecommerce.service.JwtTokenService;
import com.ecommerce.ecommerce.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthenticationController {
    
    private final AuthenticationManager manager;
    private final JwtTokenService jwtTokenService;
    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<DadosToken> logar(@RequestBody DadosAutenticacao dados){
        var token = new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());
        var authentication = manager.authenticate(token);
        var jwtToken = jwtTokenService.gerarToken((User)authentication.getPrincipal());

        return ResponseEntity.ok().body(new DadosToken(jwtToken));
    }

    @PostMapping("/cadastrar")
    @Operation(summary = "Cadastrar usuário", description = "Cadastra um novo usuário")
    @ApiResponse(responseCode = "200", description = "Usuário cadastrado")
    public ResponseEntity<UserDTO> register(@RequestBody @Valid UserRequest user){
        return ResponseEntity.ok().body(this.authenticationService.register(user));
    }
}
