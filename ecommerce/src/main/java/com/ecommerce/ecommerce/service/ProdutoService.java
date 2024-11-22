package com.ecommerce.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.dto.ProdutoDTO;
import com.ecommerce.ecommerce.dto.request.ProdutoRequest;
import com.ecommerce.ecommerce.mapper.ProdutoMapper;
import com.ecommerce.ecommerce.model.Categoria;
import com.ecommerce.ecommerce.model.Produto;
import com.ecommerce.ecommerce.repository.CategoriaRepository;
import com.ecommerce.ecommerce.repository.ProdutoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRespository;
    private final CategoriaRepository categoriaRespository;

    public List<ProdutoDTO> getAll(){
        List<Produto> produtos = this.produtoRespository.findAll();
        return ProdutoMapper.toDtoList(produtos);
    }

    public ProdutoDTO getById(Long id){
        Produto produto = this.getByProdutoId(id);

        if(produto == null){
            return null;
        }

        return ProdutoMapper.toDto(produto);
    }

    public ProdutoDTO create(ProdutoRequest produto){
        Categoria categoria = this.findCategoriaByNome(produto.getCategoria());

        if(categoria == null){
            return null;
        }

        Produto novoProduto = ProdutoMapper.requestToModel(produto, categoria);

        this.produtoRespository.save(novoProduto);

        return ProdutoMapper.toDto(novoProduto);
    }

    private Categoria findCategoriaByNome(String nome){
        return this.categoriaRespository.findByNome(nome);
    }

    private Produto getByProdutoId(Long id){
        Optional<Produto> op = this.produtoRespository.findById(id);

        if(op.isPresent()){
            return op.get();
        }

        return null;
    }
}
