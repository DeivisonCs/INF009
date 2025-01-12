package com.produto.produto_ms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.produto.produto_ms.dto.PedidoDTO;
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
    
    public ProdutoResponse getProductBySerialNumber(String serialNumber){
        Produto product = this.getBySerialNumber(serialNumber);

        if(product == null) {
            throw new NotFoundException("Produto não encontrado");
        }

        return ProdutoMapper.modelToResponse(product);
    }
    
    public List<ProdutoResponse> getAllProducts(){
        List<Produto> allProducts = this.produtoRepository.findAll();

        return ProdutoMapper.modelToResponseList(allProducts);
    }

    public void updateStock(List<PedidoDTO> productsToUpdate){
        Map<Long, Integer> stockToUpdate = productsToUpdate.stream().collect(Collectors.toMap(PedidoDTO::productId, PedidoDTO::amount));
        List<Long> productIds = new ArrayList<>(stockToUpdate.keySet());

        List<Produto> products = this.produtoRepository.findAllById(productIds);

        for (Produto product : products) {
            Integer newValue = stockToUpdate.get(product.getId());

            if (newValue != null) {
                product.setStock(newValue);
            }
        }
        
        this.produtoRepository.saveAll(products);
    }

    public ProdutoResponse updateProduct(Long id, ProdutoRequest newData){
        Produto productToUpdate = this.getById(id);

        if(productToUpdate == null) {
            throw new NotFoundException("Produto não encontrado");
        }

        Produto updatedProdut = ProdutoMapper.requestToModel(newData);
        updatedProdut.setId(productToUpdate.getId());
        
        this.produtoRepository.save(updatedProdut);
        return ProdutoMapper.modelToResponse(updatedProdut);
    }

    private Produto getById(Long id){
        Optional<Produto> op = this.produtoRepository.findById(id);
        
        if(op.isPresent()){
            return op.get();
        }

        return null;
    }
    
    private Produto getBySerialNumber(String serialNumber){
        Optional<Produto> op = this.produtoRepository.findBySerialNumber(serialNumber);
        
        if(op.isPresent()){
            return op.get();
        }

        return null;
    }
}
