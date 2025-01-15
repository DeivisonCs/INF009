package com.pedido.pedido_ms.dto;

import com.pedido.pedido_ms.model.Produto;

public class ProdutoDTO {

    private Long productId;
    private String name;
    private String serialNumber;
    private String manufacturer;

    public ProdutoDTO (Produto product){
        this.productId = product.getId();
        this.name = product.getName();
        this.serialNumber = product.getSerialNumber();
        this.manufacturer = product.getManufacturer();
    }

    public Long getProductId() {
        return productId;
    }

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
