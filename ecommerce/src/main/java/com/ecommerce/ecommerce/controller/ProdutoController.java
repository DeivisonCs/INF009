package com.ecommerce.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/produto")
public class ProdutoController {

    // @GetMapping
    // @Operation(summary = "Listar produtos", description = "Retorna todas as produtos cadastradas")
    // @ApiResponse(responseCode = "200", description = "Lista de produtos")
    // public ResponseEntity<List<CategoriaDTO>> getAll(){
    //     return ResponseEntity.ok().body(this.categoriaService.getAll());
    // }

    // @GetMapping("/{id}")
    // @Operation(summary = "Listar produto", description = "Retorna uma produto específica")
    // @ApiResponses(value = {
    //     @ApiResponse(responseCode = "200", description = "Retorna produto"),
    //     @ApiResponse(responseCode = "404", description = "Produto não encontrada"),
    // })
    // public ResponseEntity<CategoriaDTO> getById(@PathVariable Long id){
    //     CategoriaDTO categoria = this.categoriaService.getById(id);

    //     if(categoria == null){
    //         return ResponseEntity.notFound().build();
    //     }

    //     return ResponseEntity.ok().body(categoria);
    // }
}
