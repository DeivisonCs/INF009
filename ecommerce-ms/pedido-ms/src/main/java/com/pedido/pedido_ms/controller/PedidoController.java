package com.pedido.pedido_ms.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pedido.pedido_ms.dto.enums.OrderStatus;
import com.pedido.pedido_ms.dto.request.PedidoRequest;
import com.pedido.pedido_ms.dto.response.PedidoResponse;
import com.pedido.pedido_ms.dto.response.StatusResponse;
import com.pedido.pedido_ms.service.PedidoService;
import com.pedido.pedido_ms.service.StatusService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/order")
public class PedidoController {

    private final PedidoService pedidoService;
    private final StatusService statusService;

    public PedidoController (PedidoService pedidoService, StatusService statusService){
        this.pedidoService = pedidoService;
        this.statusService = statusService;
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
   
    @GetMapping("/status")
    public ResponseEntity<List<StatusResponse>> getAllStatus(){
        return ResponseEntity.ok().body(this.statusService.getStatus());
    }
    
    @PatchMapping("/update/status/{orderId}/{status}")
    public ResponseEntity<Void> updateOrderStatus(@PathVariable Long orderId, @PathVariable OrderStatus status){
        this.pedidoService.updateOrderStatus(orderId, status);
        return ResponseEntity.ok().build();
    }

}
