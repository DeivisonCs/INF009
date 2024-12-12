package br.ifba.api.petcommerce.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifba.api.petcommerce.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
