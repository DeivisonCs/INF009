package com.ecommerce.ecommerce.mapper;

import java.util.List;

import com.ecommerce.ecommerce.dto.CategoriaDTO;
import com.ecommerce.ecommerce.dto.request.CategoriaRequest;
import com.ecommerce.ecommerce.model.Categoria;

public class CategoriaMapper {

    public static List<CategoriaDTO> toDtoList(List<Categoria> categorias){
        return categorias.stream().map(CategoriaDTO::new).toList();
    }

    public static CategoriaDTO toDto(Categoria categoria){
        return new CategoriaDTO(categoria);
    }

    public static Categoria requestToModel(CategoriaRequest categoria){
        return new Categoria(categoria);
    }
}
