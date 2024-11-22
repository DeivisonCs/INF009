package com.ecommerce.ecommerce.mapper;

import java.util.List;

import com.ecommerce.ecommerce.dto.ProdutoDTO;
import com.ecommerce.ecommerce.dto.request.ProdutoRequest;
import com.ecommerce.ecommerce.model.Categoria;
import com.ecommerce.ecommerce.model.Produto;

public class ProdutoMapper {

    public static List<ProdutoDTO> toDtoList(List<Produto> produtos){
        return produtos.stream().map(ProdutoDTO::new).toList();
    }
    
    public static ProdutoDTO toDto(Produto produto){
        return new ProdutoDTO(produto);
    }

    public static Produto requestToModel(ProdutoRequest produto, Categoria categoria){
        return new Produto(produto, categoria);
    }
}
