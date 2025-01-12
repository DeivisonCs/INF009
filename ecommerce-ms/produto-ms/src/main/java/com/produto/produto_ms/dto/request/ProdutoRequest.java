package com.produto.produto_ms.dto.request;

import com.produto.produto_ms.dto.ValidationGroup;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProdutoRequest {

    @NotBlank(message = "Informe o nome", groups = {ValidationGroup.Create.class, ValidationGroup.Update.class})
    @NotNull(message = "Nome não pode ser nulo", groups = ValidationGroup.Create.class)
    private String name;

    @NotBlank(message = "Informe o número de serie", groups = {ValidationGroup.Create.class, ValidationGroup.Update.class})
    @NotNull(message = "Número de serie não pode ser nulo", groups = ValidationGroup.Create.class)
    private String serialNumber;

    @NotBlank(message = "Informe o fabricante", groups = {ValidationGroup.Create.class, ValidationGroup.Update.class})
    @NotNull(message = "Fabricante não pode ser nulo", groups = ValidationGroup.Create.class)
    private String manufacturer;

    @NotNull(message = "Quantidade em estoque não pode nula", groups = ValidationGroup.Create.class)
    @Min(value = 0, message = "A quantidade em estoque não pode ser negativa", groups = {ValidationGroup.Create.class, ValidationGroup.Update.class})
    private Integer stock;

    public String getName() {
        return name;
    }
    
    public String getSerialNumber() {
        return serialNumber;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public Integer getStock() {
        return stock;
    }

}
