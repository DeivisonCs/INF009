package com.pedido.pedido_ms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class PedidoProduto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido order;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto product;

    private Integer amount;

    private Double unitPrice;

    public PedidoProduto() {}

    public void setId(Long id) {
        this.id = id;
    }

    public void setOrder(Pedido order) {
        this.order = order;
    }

    public void setProduct(Produto product) {
        this.product = product;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Long getId() {
        return id;
    }

    public Pedido getOrder() {
        return order;
    }

    public Produto getProduct() {
        return product;
    }

    public Integer getAmount() {
        return amount;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }
}
