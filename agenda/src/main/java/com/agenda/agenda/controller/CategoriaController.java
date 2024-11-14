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

import com.agenda.agenda.dto.CategoriaDTO;
import com.agenda.agenda.dto.request.CategoriaRequest;
import com.agenda.agenda.service.CategoriaService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/categoria")
@AllArgsConstructor
public class CategoriaController {
    private final CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> getAll(){
        return ResponseEntity.ok().body(this.categoriaService.getAll());
    }
    
    @GetMapping("{id}")
    public ResponseEntity<CategoriaDTO> getById(@PathVariable Long id){
        return this.categoriaService.getCategoriaById(id);
    }

    @PostMapping
    public ResponseEntity<CategoriaDTO> create(@RequestBody @Valid CategoriaRequest novaCategoria){
        return ResponseEntity.ok().body(this.categoriaService.create(novaCategoria));
    }
    
    @PutMapping("{id}")
    public ResponseEntity<CategoriaDTO> update(@PathVariable Long id, @RequestBody CategoriaRequest novosDados){
        return this.categoriaService.update(id, novosDados);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        return this.categoriaService.delete(id);
    }
}
