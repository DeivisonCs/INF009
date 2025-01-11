package com.produto.produto_ms.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProdutoRequest {

    @NotBlank(message = "Informe o nome")
    @NotNull(message = "Nome não pode nulo")
    private String name;

    @NotBlank(message = "Informe o fabricante")
    @NotNull(message = "Fabricante não pode nulo")
    private String manufacturer;

    @NotNull(message = "Quantidade em estoque não pode nula")
    @Min(0)
    private Integer stock;

    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public Integer getStock() {
        return stock;
    }

}
