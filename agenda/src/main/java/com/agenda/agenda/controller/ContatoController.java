package com.agenda.agenda.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<ContatoDTO> create(@Valid @RequestBody ContatoRequest novoContato){
        return this.contatoService.create(novoContato);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        return this.contatoService.delete(id);
    }
    
    @PutMapping("{id}")
    public ResponseEntity<ContatoDTO> update(@PathVariable Long id, @RequestBody ContatoRequest contato){
        return this.contatoService.update(id, contato);
    }
}
