package com.pedido.pedido_ms.dto.request;

import java.util.Set;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class PedidoRequest {

    @NotNull(message = "CPF do comprador não deve ser nulo")
    private String buyerCpf;

    private Set<PedidoProdutoRequest> products;

    @NotNull(message = "Preço total não deve ser nulo")
    @Min(value = 0)
    private Double price;

    public String getBuyerCpf(){
        return buyerCpf;
    }

    public Set<PedidoProdutoRequest> getProducts() {
        return products;
    }

    public Double getPrice() {
        return price;
    }
}
