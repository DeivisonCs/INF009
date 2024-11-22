package com.ecommerce.ecommerce.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecommerce.ecommerce.dto.ProdutoDTO;
import com.ecommerce.ecommerce.dto.request.ProdutoRequest;
import com.ecommerce.ecommerce.service.ProdutoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/api/produto")
public class ProdutoController {
    private final ProdutoService produtoService;

    @GetMapping
    @Operation(summary = "Listar produtos", description = "Retorna todas as produtos cadastradas")
    @ApiResponse(responseCode = "200", description = "Lista de produtos")
    public ResponseEntity<List<ProdutoDTO>> getAll(){
        return ResponseEntity.ok().body(this.produtoService.getAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Listar produto", description = "Retorna um produto específico")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Retorna produto"),
        @ApiResponse(responseCode = "404", description = "Produto não encontrado"),
    })
    public ResponseEntity<ProdutoDTO> getById(@PathVariable Long id){
        ProdutoDTO produto = this.produtoService.getById(id);

        if(produto == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(produto);
    }

    @PostMapping()
    @Operation(summary = "Cadastrar produto", description = "Cadastra uma nova produto")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Produto cadastrado"),
        @ApiResponse(responseCode = "404", description = "Erro ao cadastrar produto")
    })
    public ResponseEntity<ProdutoDTO> create(@RequestBody @Valid ProdutoRequest produto){
        ProdutoDTO novoProduto = this.produtoService.create(produto);

        if(novoProduto == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok().body(novoProduto);
    }
}
