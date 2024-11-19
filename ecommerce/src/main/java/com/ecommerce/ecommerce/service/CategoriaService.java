package com.ecommerce.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.dto.CategoriaDTO;
import com.ecommerce.ecommerce.dto.request.CategoriaRequest;
import com.ecommerce.ecommerce.mapper.CategoriaMapper;
import com.ecommerce.ecommerce.model.Categoria;
import com.ecommerce.ecommerce.repository.CategoriaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    public List<CategoriaDTO> getAll(){
        return CategoriaMapper.toDtoList(this.categoriaRepository.findAll());
    }

    public CategoriaDTO getById(Long id){
        Categoria categoria = this.findById(id);

        if(categoria == null){
            return null;
        }

        return CategoriaMapper.toDto(categoria);
    }

    public CategoriaDTO create(CategoriaRequest categoria){
        Categoria novaCategoria = CategoriaMapper.requestToModel(categoria);
        this.categoriaRepository.save(novaCategoria);

        return CategoriaMapper.toDto(novaCategoria);
    }

    private Categoria findById(Long id){
        Optional<Categoria> op = this.categoriaRepository.findById(id);

        if(op.isPresent()){
            return op.get();
        }
        return null;
    }
}
