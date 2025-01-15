package com.pedido.pedido_ms.mapper;

import java.util.List;

import com.pedido.pedido_ms.dto.response.PedidoResponse;
import com.pedido.pedido_ms.model.Pedido;

public class PedidoMapper {

    public static PedidoResponse modelToResponse(Pedido order){
        return new PedidoResponse(order);
    }
  
    public static List<PedidoResponse> modelListToResponseList(List<Pedido> orders){
        return orders.stream().map(PedidoResponse::new).toList();
    }
}
