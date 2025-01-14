package com.pedido.pedido_ms.dto;

import com.pedido.pedido_ms.model.Produto;

public class ProdutoDTO {

    private Long id;
    private String name;
    private String serialNumber;
    private String manufacturer;

    public ProdutoDTO (Produto product){
        this.id = product.getId();
        this.name = product.getName();
        this.serialNumber = product.getSerialNumber();
        this.manufacturer = product.getManufacturer();
    }
}
