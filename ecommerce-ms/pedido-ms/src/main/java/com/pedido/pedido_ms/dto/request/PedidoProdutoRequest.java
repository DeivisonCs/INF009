package com.pedido.pedido_ms.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class PedidoProdutoRequest {

    private ProdutoRequest product;

    @NotNull(message = "Qunatidade comprada não deve ser nula")
    @Min(value = 1)
    private Integer amount;
    
    @NotNull(message = "Preço unitário não deve ser nulo")
    @Min(value = 0)
    private Double unitPrice;

    public ProdutoRequest getProduct() {
        return product;
    }

    public Integer getAmount() {
        return amount;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }
}
