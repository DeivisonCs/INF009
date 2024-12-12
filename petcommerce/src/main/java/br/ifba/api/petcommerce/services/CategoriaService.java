package br.ifba.api.petcommerce.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.ifba.api.petcommerce.dtos.CategoriaDTO;
import br.ifba.api.petcommerce.entities.Categoria;
import br.ifba.api.petcommerce.respositories.CategoriaRepository;

@Service
public class CategoriaService {

	private CategoriaRepository categoriaRepository;
	
	public CategoriaService(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}
	
	public List<CategoriaDTO> findAll() {
		return categoriaRepository.findAll().stream().map(CategoriaDTO::new).toList();
	}
	
	public CategoriaDTO post(CategoriaDTO categoriaDTO) {
		return new CategoriaDTO(categoriaRepository.save(new Categoria(categoriaDTO)));
	}

	public CategoriaDTO put(CategoriaDTO categoriaDTO) {
		// TODO Auto-generated method stub
		Optional<Categoria> op = categoriaRepository.findById(categoriaDTO.id());
		if (op.isEmpty()) {
			return null;
		}else {
		Categoria categoria = op.get(); 
		categoria.setNome(categoriaDTO.nome());
		this.categoriaRepository.save(categoria);
		return categoriaDTO;
		}
	}

	public CategoriaDTO delete(Long id) {
		Optional<Categoria> op = categoriaRepository.findById(id);
		if (op.isEmpty()) {
            return null;
        }else {
			Categoria categoria = op.get();
			categoriaRepository.delete(categoria);
			return new CategoriaDTO(categoria);
        }
	}
	
}
