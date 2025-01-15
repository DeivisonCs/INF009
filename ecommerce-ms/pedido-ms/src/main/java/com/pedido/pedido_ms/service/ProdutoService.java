package com.pedido.pedido_ms.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pedido.pedido_ms.client.produtoMs.ProdutoClient;
import com.pedido.pedido_ms.client.produtoMs.ProdutoClientResponse;
import com.pedido.pedido_ms.client.produtoMs.StockResponse;
import com.pedido.pedido_ms.exception.NotFoundException;
import com.pedido.pedido_ms.mapper.ProdutoMapper;
import com.pedido.pedido_ms.model.Produto;
import com.pedido.pedido_ms.repository.ProdutoRepository;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final ProdutoClient produtoClient;

    public ProdutoService(ProdutoRepository produtoRepository, ProdutoClient produtoClient){
        this.produtoRepository = produtoRepository;
        this.produtoClient = produtoClient;
    }

    private Produto registerProduct(String serialNumber){
        ProdutoClientResponse clientResponse = this.produtoClient.getProductBySerialNumber(serialNumber);

        if(clientResponse == null){
            throw new NotFoundException("Não foi possível recuperar dados do produto");
        }

        Produto product = ProdutoMapper.clientResponseToModel(clientResponse);
        this.produtoRepository.save(product);
        
        return product;
    }

    public Boolean isInStock(String serialNumber){
        StockResponse stock = this.produtoClient.isInStock(serialNumber);

        return stock.isInStock();
    }

    public Produto getProduct(String serialNumber){
        Optional<Produto> op = this.produtoRepository.findBySerialNumber(serialNumber);

        if(!op.isPresent()){
            return this.registerProduct(serialNumber);
        }

        return op.get();
    }

}
