package com.pedido.pedido_ms.mapper;

import java.util.Set;
import java.util.stream.Collectors;

import com.pedido.pedido_ms.dto.PedidoProdutoDTO;
import com.pedido.pedido_ms.dto.ProdutoDTO;
import com.pedido.pedido_ms.dto.request.ProdutoRequest;
import com.pedido.pedido_ms.model.PedidoProduto;
import com.pedido.pedido_ms.model.Produto;

public class ProdutoMapper {

    public static Produto requestToModel(ProdutoRequest product){
        return new Produto(product);
    }

    public static ProdutoDTO modelToRequest(Produto product){
        return new ProdutoDTO(product);
    }

    public static Set<PedidoProdutoDTO> modelSetToResponse(Set<PedidoProduto> products){
        return products.stream().map(PedidoProdutoDTO::new).collect(Collectors.toSet());
    }
}
