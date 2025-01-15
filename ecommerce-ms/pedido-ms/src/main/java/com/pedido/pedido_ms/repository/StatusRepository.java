package com.pedido.pedido_ms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedido.pedido_ms.model.Status;

public interface StatusRepository extends JpaRepository<Status, Long> {
    public Status findByName(String name);
}
