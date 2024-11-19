package com.ecommerce.ecommerce.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecommerce.ecommerce.dto.CategoriaDTO;
import com.ecommerce.ecommerce.dto.request.CategoriaRequest;
import com.ecommerce.ecommerce.service.CategoriaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/api/categoria")
@AllArgsConstructor
public class CategoriaController {
    private final CategoriaService categoriaService;

    @GetMapping
    @Operation(summary = "Listar categorias", description = "Retorna todas as categorias cadastradas")
    @ApiResponse(responseCode = "200", description = "Lista de categorias")
    public ResponseEntity<List<CategoriaDTO>> getAll(){
        return ResponseEntity.ok().body(this.categoriaService.getAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Listar categoria", description = "Retorna uma categoria específica")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Retorna categoria"),
        @ApiResponse(responseCode = "404", description = "Categoria não encontrada"),
    })
    public ResponseEntity<CategoriaDTO> getById(@PathVariable Long id){
        CategoriaDTO categoria = this.categoriaService.getById(id);

        if(categoria == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(categoria);
    }
    
    @PostMapping()
    @Operation(summary = "Cadastrar categoria", description = "Cadastra uma nova categoria")
    @ApiResponse(responseCode = "201", description = "Categoria cadastrada")
    public ResponseEntity<CategoriaDTO> create(@RequestBody @Valid CategoriaRequest categoria){
        return ResponseEntity.ok().body(this.categoriaService.create(categoria));
    }

}
