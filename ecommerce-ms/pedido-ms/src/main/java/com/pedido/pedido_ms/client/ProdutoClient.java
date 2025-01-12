package com.pedido.pedido_ms.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:8082/produto-ms", name = "produto-ms")
public interface ProdutoClient {

    @GetMapping("/product/serial/{serialNumber}")
    public ProdutoClientResponse getProductBySerialNumber(@PathVariable String serialNumber);
}