package com.pedido.pedido_ms.mapper;

import com.pedido.pedido_ms.dto.CompradorDTO;
import com.pedido.pedido_ms.model.Comprador;

public class CompradorMapper {
    public static CompradorDTO modelToDTO(Comprador buyer){
        return new CompradorDTO(buyer);
    }
}
