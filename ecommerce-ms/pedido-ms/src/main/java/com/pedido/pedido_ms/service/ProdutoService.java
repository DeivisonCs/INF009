package com.pedido.pedido_ms.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.pedido.pedido_ms.dto.request.PedidoProdutoRequest;
import com.pedido.pedido_ms.dto.request.ProdutoRequest;
import com.pedido.pedido_ms.mapper.ProdutoMapper;
import com.pedido.pedido_ms.model.PedidoProduto;
import com.pedido.pedido_ms.model.Produto;
import com.pedido.pedido_ms.repository.PedidoProdutoRepository;
import com.pedido.pedido_ms.repository.ProdutoRepository;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final PedidoProdutoRepository pedidoProdutoRepository;

    public ProdutoService(ProdutoRepository produtoRepository, PedidoProdutoRepository pedidoProdutoRepository){
        this.produtoRepository = produtoRepository;
        this.pedidoProdutoRepository = pedidoProdutoRepository;
    }

    private Produto registerProduct(ProdutoRequest productToRegister){
        Produto product = ProdutoMapper.requestToModel(productToRegister);

        this.produtoRepository.save(product);

        return product;
    }

    public Produto getProduct(ProdutoRequest product){
        Optional<Produto> op = this.produtoRepository.findBySerialNumber(product.getSerialNumber());

        if(!op.isPresent()){
            return this.registerProduct(product);
        }

        return op.get();
    }

    // public List<Produto> getProducts(List<ProdutoRequest> productsRequest){
    //     Set<String> serialNumbers = productsRequest
    //                                     .stream()
    //                                     .map(ProdutoRequest::getSerialNumber)
    //                                     .collect(Collectors.toSet());

    //     // Procura produtos que jjá foram adicionados anteriormente
    //     List<Produto> products = this.produtoRepository.findAllBySerialNumberIn(serialNumbers);

    //     // Caso algum produto da requisião não tenha sido cadastrado
    //     for (Produto product : products) {

    //         if(!serialNumbers.contains(product.getSerialNumber())){
    //             products.add(this.findProductToRegister(product, productsRequest));
    //         }

    //     }

    //     return products;
    // }

    // private Produto findProductToRegister(Produto product, List<ProdutoRequest> productsRequest){
    //     ProdutoRequest productToRegister = null;

    //     for (ProdutoRequest productInRequest : productsRequest) {
    //         if (productInRequest.getSerialNumber().equals(product.getSerialNumber())) {
    //             productToRegister = productInRequest;
    //             break;
    //         }
    //     }

    //     return this.registerProduct(productToRegister);
    // }
    
}
