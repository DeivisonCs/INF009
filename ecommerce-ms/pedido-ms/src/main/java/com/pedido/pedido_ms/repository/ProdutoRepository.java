package com.pedido.pedido_ms.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedido.pedido_ms.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    // public List<Produto> findAllBySerialNumberIn(Set<String> serialNumbers);
    public Optional<Produto> findBySerialNumber(String serialNumber);
}
