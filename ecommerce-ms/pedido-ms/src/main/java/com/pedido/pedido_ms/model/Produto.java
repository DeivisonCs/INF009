package com.pedido.pedido_ms.model;

import com.pedido.pedido_ms.dto.request.ProdutoRequest;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String manufacturer;

    @Column(unique = true)
    private String serialNumber;

    public Produto(){}

    public Produto(ProdutoRequest product){
        this.name = product.getName();
        this.manufacturer = product.getManufacturer();
        this.serialNumber = product.getSerialNumber();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getSerialNumber() {
        return serialNumber;
    }
}
