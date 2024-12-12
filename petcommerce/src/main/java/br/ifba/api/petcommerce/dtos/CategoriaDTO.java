package br.ifba.api.petcommerce.dtos;

import br.ifba.api.petcommerce.entities.Categoria;
import io.swagger.v3.oas.annotations.media.Schema;

public record CategoriaDTO(
		@Schema(name = "id", example = "1") Long id,
		@Schema(name = "nome", example = "Domesticos") String nome) {

	public CategoriaDTO(Categoria categoria) {
        this(categoria.getId(), categoria.getNome());
    }
	
}
