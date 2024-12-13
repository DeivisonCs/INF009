package com.prova1.prova.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PeixeRequest {

    @NotNull
    @NotBlank
    private String nome;
    @NotNull
    @NotBlank
    private String especie;
    @NotNull
    @Min(0)
    private Double preco;
    @NotNull
    @Min(0)
    private Integer quantidadeEmEstoque;

    public String getNome() {
        return nome;
    }

    public String getEspecie() {
        return especie;
    }

    public Double getPreco() {
        return preco;
    }

    public Integer getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

}
