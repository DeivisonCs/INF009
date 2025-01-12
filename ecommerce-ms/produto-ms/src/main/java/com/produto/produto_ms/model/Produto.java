package com.produto.produto_ms.model;

import com.produto.produto_ms.dto.request.ProdutoRequest;

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

    @Column(unique = true)
    private String serialNumber;
    private String manufacturer;
    private Integer stock;

    public Produto(){}
    
    public Produto(ProdutoRequest product){
        this.name = product.getName();
        this.serialNumber = product.getSerialNumber();
        this.manufacturer = product.getManufacturer();
        this.stock = product.getStock();
    }

    public Long getId() {
        return id;
    }
   
    public void setId(Long id) {
        this.id = id;
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
   
    public void setStock(Integer stock) {
        this.stock = stock;
    }

}
