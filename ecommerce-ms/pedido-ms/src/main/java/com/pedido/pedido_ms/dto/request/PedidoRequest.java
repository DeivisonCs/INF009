package com.pedido.pedido_ms.dto.request;

import java.util.Set;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class PedidoRequest {

    private CompradorRequest buyer;
    private Set<PedidoProdutoRequest> products;

    @NotNull(message = "Preo total não deve ser nulo")
    @Min(value = 0)
    private Double price;

    public CompradorRequest getBuyer() {
        return buyer;
    }

    public Set<PedidoProdutoRequest> getProducts() {
        return products;
    }

    public Double getPrice() {
        return price;
    }
}
