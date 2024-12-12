package br.ifba.api.petcommerce.dtos;

import br.ifba.api.petcommerce.entities.Cliente;
import io.swagger.v3.oas.annotations.media.Schema;

public record ClienteDTO(
		@Schema(name = "id", example = "1")Long id, 
		@Schema(name = "nome", example = "Maria da Silva")String nome, 
		@Schema(name = "email", example = "maria@gmail.com")String email, 
		@Schema(name = "telefone", example = "71999776655")String telefone, 
		EnderecoDTO endereco) {
	
	public ClienteDTO(Cliente cliente) {
		this(cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getTelefone(), new EnderecoDTO(cliente.getEndereco()));
	}
}
