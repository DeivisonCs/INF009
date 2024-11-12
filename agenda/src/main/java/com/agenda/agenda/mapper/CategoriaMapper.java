package com.agenda.agenda.mapper;

import java.util.List;

import com.agenda.agenda.dto.CategoriaDTO;
import com.agenda.agenda.model.Categoria;

public class CategoriaMapper { 
    public static List<CategoriaDTO> toDtoList(List<Categoria> categorias){
        return categorias.stream().map(CategoriaDTO::new).toList();
    }

    public static CategoriaDTO toDto(Categoria categoria){
        return new CategoriaDTO(categoria);
    }
}
