package com.produto.produto_ms.dto.response;

import com.produto.produto_ms.model.Produto;

public class ProdutoResponse {
    private Long id;
    private String name;
    private String serialNumber;
    private String manufacturer;
    private Integer stock;

    public ProdutoResponse(Produto product){
        this.id = product.getId();
        this.serialNumber = product.getSerialNumber();
        this.name = product.getName();
        this.manufacturer = product.getManufacturer();
        this.stock = product.getStock();
    }

    public Long getId() {
        return id;
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

    public Integer getStock() {
        return stock;
    }

}
