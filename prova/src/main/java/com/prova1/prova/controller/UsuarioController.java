package com.prova1.prova.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prova1.prova.dto.request.UsuarioRequest;
import com.prova1.prova.service.UsuarioService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/user")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }


    @PostMapping
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid UsuarioRequest user){
        this.usuarioService.create(user);
        return ResponseEntity.ok().build();
    }
}
