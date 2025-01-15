package com.pedido.pedido_ms.client.produtoMs;

public record ProdutoClientResponse(
    String name,
    String serialNumber,
    String manufacturer
) {}