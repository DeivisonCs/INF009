package com.produto.produto_ms.mapper;

import java.util.List;

import com.produto.produto_ms.dto.request.ProdutoRequest;
import com.produto.produto_ms.dto.response.ProdutoResponse;
import com.produto.produto_ms.model.Produto;

public class ProdutoMapper {

    public static Produto requestToModel(ProdutoRequest product){
        return new Produto(product);
    }
    
    public static ProdutoResponse modelToResponse(Produto product){
        return new ProdutoResponse(product);
    }
    
    public static List<ProdutoResponse> modelToResponseList(List<Produto> products){
        return products.stream().map(ProdutoResponse::new).toList();
    }

    public static List<Produto> requestToModelList(List<ProdutoRequest> products){
        return products.stream().map(Produto::new).toList();
    }
}
