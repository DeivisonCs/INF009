package com.pedido.pedido_ms.mapper;

import com.pedido.pedido_ms.dto.CompradorDTO;
import com.pedido.pedido_ms.dto.request.CompradorRequest;
import com.pedido.pedido_ms.model.Comprador;

public class CompradorMapper {

    public static Comprador requestToModel(CompradorRequest buyer){
        return new Comprador(buyer);
    }

    public static CompradorDTO modelToDTO(Comprador buyer){
        return new CompradorDTO(buyer);
    }
}
