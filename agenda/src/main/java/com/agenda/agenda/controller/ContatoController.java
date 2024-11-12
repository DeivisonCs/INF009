package com.agenda.agenda.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.agenda.agenda.dto.ContatoDTO;
import com.agenda.agenda.dto.request.ContatoRequest;
import com.agenda.agenda.service.ContatoService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/contato")
@AllArgsConstructor
public class ContatoController {
    private final ContatoService contatoService;

    @GetMapping
    public ResponseEntity<List<ContatoDTO>> getAll(){
        return ResponseEntity.ok().body(this.contatoService.getAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ContatoDTO> getById(@PathVariable Long id){
        return this.contatoService.getById(id);
    }

    @PostMapping
    public ResponseEntity<ContatoDTO> create(@RequestBody @Valid ContatoRequest novoContato, UriComponentsBuilder uribuilder){
        return this.contatoService.create(novoContato, uribuilder);
    }
}
