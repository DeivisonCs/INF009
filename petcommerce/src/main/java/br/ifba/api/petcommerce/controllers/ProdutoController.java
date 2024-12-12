package br.ifba.api.petcommerce.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifba.api.petcommerce.dtos.ProdutoDTO;
import br.ifba.api.petcommerce.services.ProdutoSevice;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	private ProdutoSevice produtoSevice;
	
	
	public ProdutoController(ProdutoSevice produtoSevice) {
		this.produtoSevice = produtoSevice;
	}
	
	@Operation(summary = "Cadastrar Produtos", description = "Cadastra um novo priduto no sistema. Retorna o produto cadastrado")
    @ApiResponse(responseCode = "201", description = "Cadastrar Produtos")
	@PostMapping
	public ResponseEntity<ProdutoDTO> post(@RequestBody ProdutoDTO produtoDTO) {
		// Created Status Code
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoSevice.salvar(produtoDTO));
	}
	
	@Operation(summary = "Listar Produtos", description = "Lista todos os produtos do sistema.")
    @ApiResponse(responseCode = "200", description = "Listar Produtos")
	@GetMapping
	public ResponseEntity<Page<ProdutoDTO>> findAll(Pageable pageble) {
		return ResponseEntity.ok(new PageImpl<>(produtoSevice.listar(), pageble, produtoSevice.listar().size()));
	}
	
	@Operation(summary = "Alterar Produtos", description = "Altera um produto. Retorna o produto alterado.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente alterado"),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado")})
	@PutMapping("/{id}")
	public ResponseEntity<ProdutoDTO> alterar(@PathVariable Long id, @RequestBody ProdutoDTO produtoDTO){
		ProdutoDTO produto = produtoSevice.atualizar(id,produtoDTO);
		if (produto == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(produto); 
	}
	
	@Operation(summary = "Apagar Produtos", description = "Apaga um produto. Retorna o produto apagado.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto apagado"),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado")})
	@DeleteMapping("/{id}")
	public ResponseEntity<ProdutoDTO> delete(@PathVariable Long id) {
		ProdutoDTO produto = produtoSevice.deletar(id);
		if (produto == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(produto);
	}
}
