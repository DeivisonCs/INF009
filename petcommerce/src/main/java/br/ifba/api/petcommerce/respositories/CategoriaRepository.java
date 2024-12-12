package br.ifba.api.petcommerce.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifba.api.petcommerce.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
