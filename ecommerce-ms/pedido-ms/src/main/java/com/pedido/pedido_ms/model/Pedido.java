package com.pedido.pedido_ms.model;

import java.time.Instant;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Comprador buyer;
    
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private Set<PedidoProduto> products;
    private Double price;
    private Instant instant;

    @ManyToOne
    private Status status;

    public Pedido(){
        this.instant = Instant.now();
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public void setStatus(Status status) {
        this.status = status;
    }

    public void setBuyer(Comprador buyer) {
        this.buyer = buyer;
    }

    public void setProducts(Set<PedidoProduto> products) {
        this.products = products;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public Comprador getBuyer() {
        return buyer;
    }

    public Set<PedidoProduto> getProducts() {
        return products;
    }

    public Double getPrice() {
        return price;
    }

    public Instant getInstant() {
        return instant;
    }
    
    public Status getStatus() {
        return status;
    }

}
