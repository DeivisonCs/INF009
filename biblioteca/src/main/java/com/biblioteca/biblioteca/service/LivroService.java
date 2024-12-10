package com.biblioteca.biblioteca.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.biblioteca.biblioteca.dto.LivroDTO;
import com.biblioteca.biblioteca.dto.request.LivroRequest;
import com.biblioteca.biblioteca.model.Livro;
import com.biblioteca.biblioteca.repository.LivroRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LivroService {

    private final LivroRepository livroRepository;

    public LivroDTO register(LivroRequest livro){
        Livro novoLivro = this.livroRepository.save(new Livro(livro));

        return new LivroDTO(novoLivro);
    }

    public List<LivroDTO> getAll(){
        List<Livro> livros = this.livroRepository.findAll();

        return livros.stream().map(LivroDTO::new).toList();
    }
}
