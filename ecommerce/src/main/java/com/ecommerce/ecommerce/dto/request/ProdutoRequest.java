package com.ecommerce.ecommerce.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoRequest {
    @NotNull(message = "Nome nao deve ser nulo")
    @NotBlank(message = "Nome nao deve estar em branco")
    private String nome;

    private String descricao; 

    @NotNull(message = "Preço nao deve ser nulo")
    @Min(0)
    private Double preco;

    @NotNull(message = "Quantidade em estoque nao deve ser nulo")
    private int quantidadeEstoque;

    @NotNull(message = "Categoria nao deve ser nula")
    private String categoria;
}
