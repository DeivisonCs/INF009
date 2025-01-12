package com.pedido.pedido_ms.client;

import com.pedido.pedido_ms.dto.EnderecoDTO;

public record UsuarioClientResponse (
    String name,
    String email,
    String cpf,
    String contactNumber,
    EnderecoDTO address
){}
