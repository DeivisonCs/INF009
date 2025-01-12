package com.pedido.pedido_ms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedido.pedido_ms.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    
}
