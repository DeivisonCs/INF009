package com.produto.produto_ms.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.produto.produto_ms.dto.PedidoDTO;
import com.produto.produto_ms.dto.request.ProdutoRequest;
import com.produto.produto_ms.dto.response.ProdutoResponse;
import com.produto.produto_ms.service.ProdutoService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/product")
public class ProdutoController {

    private final ProdutoService produtoService;
    
    public ProdutoController (ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping("/register")
    public ResponseEntity<ProdutoResponse> register (@RequestBody @Valid ProdutoRequest product, UriComponentsBuilder uriComponentBuilder) {
        ProdutoResponse newProduct = this.produtoService.register(product);

        URI uri = uriComponentBuilder.path("/product/{id}").buildAndExpand(newProduct.getId()).toUri();

        return ResponseEntity.created(uri).body(newProduct);
    }

    @PostMapping("/register/many")
    public ResponseEntity<Void> registerMany(@RequestBody @Valid List<ProdutoRequest> products, UriComponentsBuilder uriComponentBuilder){
        this.produtoService.registerMany(products);

        URI uri = uriComponentBuilder.build().toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponse> getProductById(@PathVariable Long id){
        return ResponseEntity.ok().body(this.produtoService.getProductById(id));
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<ProdutoResponse>> getAllProducts(){
        return ResponseEntity.ok().body(this.produtoService.getAllProducts());
    }

    @PatchMapping("/update/stock")
    public ResponseEntity<Void> updateStock(@RequestBody List<PedidoDTO> toUpdate){
        this.produtoService.updateStock(toUpdate);

        return ResponseEntity.ok().build();
    }
}
