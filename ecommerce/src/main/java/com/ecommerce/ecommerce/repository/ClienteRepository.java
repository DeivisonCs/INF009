package com.ecommerce.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.ecommerce.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
