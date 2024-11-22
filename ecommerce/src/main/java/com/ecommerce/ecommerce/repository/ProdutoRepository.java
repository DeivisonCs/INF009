package com.ecommerce.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.ecommerce.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
