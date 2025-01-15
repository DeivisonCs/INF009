package com.pedido.pedido_ms.client.usuarioMs;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(url = "http://localhost:8082/usuario-ms", name = "usuario-ms")
public interface UsuarioClient {

    @GetMapping("/user/cpf")
    public UsuarioClientResponse getUserByCpf(@RequestHeader("cpf") String cpf);
}
