package br.ifba.api.petcommerce.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifba.api.petcommerce.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
