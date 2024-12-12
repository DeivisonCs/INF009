package br.ifba.api.petcommerce.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifba.api.petcommerce.entities.ItemPedido;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long>{

}
