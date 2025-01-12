package com.pedido.pedido_ms.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProdutoRequest {

    @NotNull(message = "Nome do produto não deve ser nulo")
    @NotBlank(message = "Nome do produto não deve estar em branco")
    private String name;

    @NotNull(message = "Número de série do produto não deve ser nulo")
    @NotBlank(message = "Número de série do produto não deve estar em branco")
    private String serialNumber;

    @NotNull(message = "Nome do fabricante não deve ser nulo")
    @NotBlank(message = "Nome do fabricante não deve estar em branco")
    private String manufacturer;

    public String getName() {
        return name;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getManufacturer() {
        return manufacturer;
    }
}
