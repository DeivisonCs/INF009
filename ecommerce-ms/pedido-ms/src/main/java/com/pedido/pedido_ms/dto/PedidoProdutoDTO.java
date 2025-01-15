package com.pedido.pedido_ms.dto;

import com.pedido.pedido_ms.mapper.ProdutoMapper;
import com.pedido.pedido_ms.model.PedidoProduto;

public class PedidoProdutoDTO {

    private Long orderId;
    private Integer amount;
    private Double unitPrice;
    private ProdutoDTO product;
    
    public PedidoProdutoDTO (PedidoProduto product){
        this.orderId = product.getId();
        this.amount = product.getAmount();
        this.unitPrice = product.getUnitPrice();
        this.product = ProdutoMapper.modelToDto(product.getProduct());
    }

    public Long getOrderId() {
        return orderId;
    }

    public Integer getAmount() {
        return amount;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public ProdutoDTO getProduct() {
        return product;
    }

    
}
