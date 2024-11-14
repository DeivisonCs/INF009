package com.agenda.agenda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.agenda.agenda.dto.CategoriaDTO;
import com.agenda.agenda.dto.CategoriaDetalhadaDTO;
import com.agenda.agenda.dto.request.CategoriaRequest;
import com.agenda.agenda.mapper.CategoriaMapper;
import com.agenda.agenda.model.Categoria;
import com.agenda.agenda.repository.CategoriaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    public List<CategoriaDTO> getAll(){
        List<Categoria> categorias = this.categoriaRepository.findAll();

        return CategoriaMapper.toDtoList(categorias);
    }
    
    public ResponseEntity<CategoriaDTO> getCategoriaById(Long id){
        Categoria categoria = this.getById(id);

        if(categoria == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(CategoriaMapper.toDto(categoria));
    }

    public ResponseEntity<Void> delete(Long id){
        Categoria categoria = this.getById(id);

        if(categoria == null){
            return ResponseEntity.notFound().build();
        }

        this.categoriaRepository.delete(categoria);

        return ResponseEntity.noContent().build();
    }

    public CategoriaDTO create(CategoriaRequest novaCategoria){
        Categoria categoria = new Categoria(novaCategoria);

        return CategoriaMapper.toDto(this.categoriaRepository.save(categoria));
    }
    
    public ResponseEntity<CategoriaDTO> update(Long id, CategoriaRequest novaCategoria){
        Categoria categoria = this.getById(id);

        if(categoria == null){
            return ResponseEntity.notFound().build();
        }

        Categoria updated = CategoriaMapper.toModelOnUpdate(categoria, novaCategoria);

        return ResponseEntity.ok().body(CategoriaMapper.toDto(this.categoriaRepository.save(updated)));
    }

    public ResponseEntity<CategoriaDetalhadaDTO> getDetails(Long id){
        Categoria categoria = this.getById(id);

        if(categoria == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(CategoriaMapper.toDetailsDto(categoria));
    }

    public Categoria getById(Long id){
        Optional<Categoria> op = this.categoriaRepository.findById(id);

        if(op.isPresent()){
            return op.get();
        }

        return null;
    }
}
