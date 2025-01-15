package com.pedido.pedido_ms.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pedido.pedido_ms.dto.request.PedidoRequest;
import com.pedido.pedido_ms.dto.response.PedidoResponse;
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

    @GetMapping("/all")
    public ResponseEntity<List<PedidoResponse>> getAllOrders(){
        return ResponseEntity.ok().body(this.pedidoService.getAllOrders());
    }
}
