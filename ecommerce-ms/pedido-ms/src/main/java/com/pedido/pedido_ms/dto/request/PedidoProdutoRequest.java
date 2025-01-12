package com.pedido.pedido_ms.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PedidoProdutoRequest {
    
    @NotNull(message = "Número de série não deve ser nulo")
    @NotBlank(message = "Número de série não deve estar em branco")
    private String serialNumber;

    @NotNull(message = "Quantidade comprada não deve ser nula")
    @Min(value = 1)
    private Integer amount;
    
    @NotNull(message = "Preço unitário não deve ser nulo")
    @Min(value = 0)
    private Double unitPrice;

    public String getserialNumber() {
        return serialNumber;
    }

    public Integer getAmount() {
        return amount;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }
}
