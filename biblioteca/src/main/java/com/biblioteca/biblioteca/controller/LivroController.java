package com.biblioteca.biblioteca.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.biblioteca.biblioteca.dto.LivroDTO;
import com.biblioteca.biblioteca.dto.request.LivroRequest;
import com.biblioteca.biblioteca.service.LivroService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/library/livro")
public class LivroController {

    private final LivroService livroService;

    @PostMapping
    public ResponseEntity<LivroDTO> register(@RequestBody LivroRequest livro){
        this.livroService.register(livro);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<LivroDTO>> getAll(){
        return ResponseEntity.ok().body(this.livroService.getAll());
    }
}
