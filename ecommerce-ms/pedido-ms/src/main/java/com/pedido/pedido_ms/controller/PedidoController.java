package com.pedido.pedido_ms.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pedido.pedido_ms.dto.request.PedidoRequest;
import com.pedido.pedido_ms.service.PedidoService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/order")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController (PedidoService pedidoService){
        this.pedidoService = pedidoService;
    }

    @PostMapping()
    public ResponseEntity<Void> createOrder(@RequestBody @Valid PedidoRequest order){
        this.pedidoService.registerOrder(order);

        return ResponseEntity.ok().build();
    }
}
