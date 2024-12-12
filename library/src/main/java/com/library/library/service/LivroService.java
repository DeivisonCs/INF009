package com.library.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.library.library.dto.LivroDTO;
import com.library.library.dto.request.LivroRequest;
import com.library.library.model.Livro;
import com.library.library.repository.LivroRespository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LivroService {

    private final LivroRespository livroRespository;

    public void register(LivroRequest livro){
        this.livroRespository.save(new Livro(livro));
    }

    public List<LivroDTO> getAll(){
        List<Livro> livros = this.livroRespository.findAll();
        List<LivroDTO> livrosResponse = livros.stream().map(LivroDTO::new).toList();
        
        return livrosResponse;
    }

    public ResponseEntity<Void> remove(Long id){
        Livro livro = this.findById(id);

        if(livro == null){
            return ResponseEntity.notFound().build();
        }

        this.livroRespository.delete(livro);

        return ResponseEntity.ok().build();
    }

    private Livro findById(Long id){
        Optional<Livro> op = this.livroRespository.findById(id);

        if(op.isPresent()){
            return op.get();
        }

        return null;
    }
}
