package com.produto.produto_ms.model;

import com.produto.produto_ms.dto.request.ProdutoRequest;

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
    private Integer stock;

    public Produto(){}
    
    public Produto(ProdutoRequest product){
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
