package com.usuario.usuario_ms.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.usuario.usuario_ms.dto.request.UsuarioRequest;
import com.usuario.usuario_ms.dto.response.UsuarioResponse;
import com.usuario.usuario_ms.service.UsuarioService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/user")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController (UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @PostMapping("/signup")
    public ResponseEntity<Void> register (@RequestBody @Valid UsuarioRequest user, UriComponentsBuilder uriBuilder ){
        UsuarioResponse newUser = this.usuarioService.register(user);

        URI uri = uriBuilder.path("/user/{id}").buildAndExpand(newUser.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> getUser(@PathVariable Long id){
        return ResponseEntity.ok().body(this.usuarioService.getUserById(id));
    }
}
