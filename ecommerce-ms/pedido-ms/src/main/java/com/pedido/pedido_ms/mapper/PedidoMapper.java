package com.pedido.pedido_ms.mapper;

import com.pedido.pedido_ms.dto.response.PedidoResponse;
import com.pedido.pedido_ms.model.Pedido;

public class PedidoMapper {

    public static PedidoResponse modelToResponse(Pedido order){
        return new PedidoResponse(order);
    }
}
