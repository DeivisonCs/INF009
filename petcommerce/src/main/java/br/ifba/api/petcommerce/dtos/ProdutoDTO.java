package br.ifba.api.petcommerce.dtos;

import br.ifba.api.petcommerce.entities.Produto;
import io.swagger.v3.oas.annotations.media.Schema;

public record ProdutoDTO(
		@Schema(name="id", example="1")Long id,
		@Schema(name="nome", example="ração") String nome,
		@Schema(name="descricao", example="Comida para cachorro") String descricao,
		@Schema(name="preco", example="15.99") Double preco,
		@Schema(name="quantidadeEstoque", example= "30") Integer quantidadeEstoque,
	    CategoriaDTO categoria
		
		) {
	
			public ProdutoDTO(Produto produto) {
				this(produto.getId(), produto.getNome(), produto.getDescricao(), produto.getPreco(),
						produto.getQuantidadeEstoque(), new CategoriaDTO(produto.getCategoria()));
			}

}
