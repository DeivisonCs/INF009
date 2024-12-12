package com.library.library.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.library.library.dto.LivroDTO;
import com.library.library.dto.enums.Roles;
import com.library.library.dto.request.LivroRequest;
import com.library.library.service.LivroService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/book")
@AllArgsConstructor
public class LivroController {

    private final LivroService livroService;

    @PostMapping
    @Secured(Roles.ADMIN_ROLE)
    public ResponseEntity<Void> registerBook(@RequestBody LivroRequest livro){
        this.livroService.register(livro);
        return ResponseEntity.ok().build();
    }
    
    @DeleteMapping("/{id}")
    @Secured(Roles.ADMIN_ROLE)
    public ResponseEntity<Void> removeBook(@RequestParam Long id){
        return this.livroService.remove(id);
    }
    
    @GetMapping
    public ResponseEntity<List<LivroDTO>> getAll(){
        return ResponseEntity.ok().body(this.livroService.getAll());
    }

}