package br.ifba.api.petcommerce.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.ifba.api.petcommerce.dtos.ProdutoDTO;
import br.ifba.api.petcommerce.entities.Categoria;
import br.ifba.api.petcommerce.entities.Produto;
import br.ifba.api.petcommerce.respositories.CategoriaRepository;
import br.ifba.api.petcommerce.respositories.ProdutoRepository;

@Service
public class ProdutoSevice {

	
	private	ProdutoRepository produtoRepository;
	private CategoriaRepository categoriaRepository;


	public ProdutoSevice(ProdutoRepository produtoRepository, CategoriaRepository categoriaRepository) {
		this.produtoRepository = produtoRepository;
		this.categoriaRepository = categoriaRepository;
	}
	
	public List<ProdutoDTO> listar() {
		List<Produto> produtos = produtoRepository.findAll();
		return produtos.stream().map(ProdutoDTO::new).toList();
	}
	
	public ProdutoDTO salvar(ProdutoDTO produtoDTO) {
		Produto produto = new Produto(produtoDTO);
		produtoRepository.save(produto);
		return new ProdutoDTO(produto);
	}
	
	public ProdutoDTO atualizar(Long id, ProdutoDTO produtoDTO) {
	
		Optional<Produto> optional = produtoRepository.findById(id);
		Optional<Categoria> optionalCategoria = categoriaRepository.findById(produtoDTO.categoria().id());
		if(optional.isPresent() && optionalCategoria.isPresent()) {
            Produto produto = optional.get();
            produto.setNome(produtoDTO.nome());
            produto.setDescricao(produtoDTO.descricao());
            produto.setPreco(produtoDTO.preco());
            produto.setQuantidadeEstoque(produtoDTO.quantidadeEstoque());
            produto.setCategoria(optionalCategoria.get());
            produtoRepository.save(produto);
            return new ProdutoDTO(produto);
        }
		return null;
	}
	
	public ProdutoDTO deletar(Long id) {
		Optional<Produto> optional = produtoRepository.findById(id);
		if(optional.isPresent()) {
			produtoRepository.deleteById(id);
			return new ProdutoDTO(optional.get());
		}
		return null;
	}
}
