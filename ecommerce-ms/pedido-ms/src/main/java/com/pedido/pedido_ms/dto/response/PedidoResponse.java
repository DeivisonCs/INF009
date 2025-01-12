package com.pedido.pedido_ms.dto.response;

import java.time.Instant;
import java.util.Set;

import com.pedido.pedido_ms.dto.CompradorDTO;
import com.pedido.pedido_ms.dto.PedidoProdutoDTO;
import com.pedido.pedido_ms.mapper.CompradorMapper;
import com.pedido.pedido_ms.mapper.ProdutoMapper;
import com.pedido.pedido_ms.model.Pedido;

public class PedidoResponse {

    private Long id;
    private Double price;
    private Instant instant;
    private Set<PedidoProdutoDTO> products;
    private CompradorDTO buyer;

    public PedidoResponse(Pedido order){
        this.id = order.getId();
        this.price = order.getPrice();
        this.instant = order.getInstant();
        this.products = ProdutoMapper.modelSetToResponse(order.getProducts());
        this.buyer = CompradorMapper.modelToDTO(order.getBuyer());
    }
}
