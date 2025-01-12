package com.pedido.pedido_ms.client;

public record ProdutoClientResponse(
    String name,
    String serialNumber,
    String manufacturer
) {}