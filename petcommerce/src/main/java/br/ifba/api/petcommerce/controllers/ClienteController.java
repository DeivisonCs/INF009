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
import br.ifba.api.petcommerce.dtos.ClienteDTO;
import br.ifba.api.petcommerce.services.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	private ClienteService clienteService;

	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	@Operation(summary = "Cadastrar Clientes", description = "Cadastra um novo cliente no sistema. Retorna o cliente cadastrado")
    @ApiResponse(responseCode = "201", description = "Cadastrar Clientes")
	@PostMapping
	public ResponseEntity<ClienteDTO> post(@RequestBody ClienteDTO clienteDTO) {
		// Created Status Code
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.salvar(clienteDTO));
	}
	
	@Operation(summary = "Listar Clientes", description = "Lista todos os clientes do sistema.")
    @ApiResponse(responseCode = "200", description = "Listar Clientes")
	@GetMapping
	public ResponseEntity<Page<ClienteDTO>> findAll(Pageable pageble) {
		return ResponseEntity.ok(new PageImpl<>(clienteService.listar(), pageble, clienteService.listar().size()));
	}
	
	@Operation(summary = "Alterar Clientes", description = "Altera um cliente. Retorna o cliente alterado.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente alterado"),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado")})
	@PutMapping("/{id}")
	public ResponseEntity<ClienteDTO> alterar(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO){
		ClienteDTO cliente = clienteService.atualizar(id,clienteDTO);
		if (cliente == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(cliente); 
	}
	
	@Operation(summary = "Apagar Clientes", description = "Apaga um cliente. Retorna o cliente apagado.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente apagado"),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado")})
	@DeleteMapping("/{id}")
	public ResponseEntity<ClienteDTO> delete(@PathVariable Long id) {
		ClienteDTO cliente = clienteService.deletar(id);
		if (cliente == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(cliente);
	}
	
	
}
