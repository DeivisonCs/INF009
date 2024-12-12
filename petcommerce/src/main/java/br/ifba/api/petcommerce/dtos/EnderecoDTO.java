package br.ifba.api.petcommerce.dtos;

import br.ifba.api.petcommerce.entities.Endereco;
import io.swagger.v3.oas.annotations.media.Schema;

public record EnderecoDTO(
		@Schema(name = "rua", example = "rua Clara Nunes")String rua, 
		@Schema(name = "numero", example = "55")String numero, 
		@Schema(name = "cidade", example = "Caculé")String cidade, 
		@Schema(name = "estado", example = "Bahia")String estado, 
		@Schema(name = "cep", example = "44720-000")String cep) {
	public EnderecoDTO(Endereco endereco) {
		this(endereco.getRua(), endereco.getNumero(), endereco.getCidade(), endereco.getEstado(), endereco.getCep());
	}
}
