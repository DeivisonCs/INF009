package com.produto.produto_ms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.produto.produto_ms.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
