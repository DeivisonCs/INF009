package com.produto.produto_ms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.produto.produto_ms.dto.request.ProdutoRequest;
import com.produto.produto_ms.dto.response.ProdutoResponse;
import com.produto.produto_ms.exceptions.NotFoundException;
import com.produto.produto_ms.mapper.ProdutoMapper;
import com.produto.produto_ms.model.Produto;
import com.produto.produto_ms.repository.ProdutoRepository;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService (ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public ProdutoResponse register (ProdutoRequest product) {
        Produto newProd = ProdutoMapper.requestToModel(product);

        this.produtoRepository.save(newProd);

        return ProdutoMapper.modelToResponse(newProd);
    }

    public void registerMany(List<ProdutoRequest> products){
        List<Produto> newProducts = ProdutoMapper.requestToModelList(products);

        this.produtoRepository.saveAll(newProducts);
    }

    public ProdutoResponse getProductById(Long id){
        Produto product = this.getById(id);

        if(product == null) {
            throw new NotFoundException("Produto não encontrado");
        }

        return ProdutoMapper.modelToResponse(product);
    }
    
    public List<ProdutoResponse> getAllProducts(){
        List<Produto> allProducts = this.produtoRepository.findAll();

        return ProdutoMapper.modelToResponseList(allProducts);
    }

    private Produto getById(Long id){
        Optional<Produto> op = this.produtoRepository.findById(id);
        
        if(op.isPresent()){
            return op.get();
        }

        return null;
    }
}
