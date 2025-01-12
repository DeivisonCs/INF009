package com.pedido.pedido_ms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedido.pedido_ms.model.Comprador;

public interface CompradorRepository extends JpaRepository<Comprador, Long>{

    public Optional<Comprador> findByCpf(String cpf);
}
