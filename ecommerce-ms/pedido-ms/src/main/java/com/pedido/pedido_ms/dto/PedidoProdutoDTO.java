package com.pedido.pedido_ms.dto;

import com.pedido.pedido_ms.mapper.ProdutoMapper;
import com.pedido.pedido_ms.model.PedidoProduto;

public class PedidoProdutoDTO {

    private Long id;
    private Integer amount;
    private Double unitPrice;
    private ProdutoDTO product;
    
    public PedidoProdutoDTO (PedidoProduto product){
        this.id = product.getId();
        this.amount = product.getAmount();
        this.unitPrice = product.getUnitPrice();
        this.product = ProdutoMapper.modelToDto(product.getProduct());
    }
}
