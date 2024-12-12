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

import br.ifba.api.petcommerce.dtos.CategoriaDTO;
import br.ifba.api.petcommerce.services.CategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	private CategoriaService categoriaService;
	
	public CategoriaController(CategoriaService categoriaService) {
		this.categoriaService = categoriaService;
	}
	@Operation(summary = "Listar Categorias", description = "Retorna a lista paginada de todas as categorias disponíveis")
    @ApiResponse(responseCode = "200", description = "Lista de Categorias")
	@GetMapping
	public ResponseEntity<Page<CategoriaDTO>> findAll(Pageable pageble) {
		return 	ResponseEntity.ok(new PageImpl<>(categoriaService.findAll(), pageble, categoriaService.findAll().size()));
	}
	
	
	@Operation(summary = "Cadastrar Categorias", description = "Cadastra uma nova categoria no sistema. Retorna a categoria cadastrada")
    @ApiResponse(responseCode = "201", description = "Cadastrar Categorias")
	@PostMapping
	public ResponseEntity<CategoriaDTO> post(@RequestBody CategoriaDTO categoriaDTO) {
		//Created Status Code
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.post(categoriaDTO));
	}
	
	@Operation(summary = "Alterar Categorias", description = "Altera uma categoria. Retorna a categoria alterada.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Categoria alterada"),
            @ApiResponse(responseCode = "404", description = "Categoria não encontrada")})
	@PutMapping
	public ResponseEntity<CategoriaDTO> put(@RequestBody CategoriaDTO categoriaDTO) {
		CategoriaDTO categoria = categoriaService.put(categoriaDTO);
		if (categoria == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(categoria);
	}
	
	@Operation(summary = "Apaga Categorias", description = "Apaga uma categoria. Retorna a categoria apagada.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Categoria apagada"),
            @ApiResponse(responseCode = "404", description = "Categoria não encontrada")})
	@DeleteMapping("/{id}")
	public ResponseEntity<CategoriaDTO> delete(@PathVariable Long id) {
		CategoriaDTO categoria = categoriaService.delete(id);
		if (categoria == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(categoria);
	}
	
}
