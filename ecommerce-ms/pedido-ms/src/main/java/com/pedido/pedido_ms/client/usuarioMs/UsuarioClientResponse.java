package com.pedido.pedido_ms.client.usuarioMs;

import com.pedido.pedido_ms.dto.EnderecoDTO;

public record UsuarioClientResponse (
    String name,
    String email,
    String cpf,
    String contactNumber,
    EnderecoDTO address
){}
