package com.agenda.agenda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.agenda.agenda.dto.ContatoDTO;
import com.agenda.agenda.dto.request.ContatoRequest;
import com.agenda.agenda.mapper.ContatoMapper;
import com.agenda.agenda.model.Categoria;
import com.agenda.agenda.model.Contato;
import com.agenda.agenda.repository.CategoriaRepository;
import com.agenda.agenda.repository.ContatoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ContatoService {
    private final ContatoRepository contatoRepository;
    private final CategoriaRepository categoriaRepository;

    public List<ContatoDTO> getAll(){
        List<Contato> contatos = this.contatoRepository.findAll();

        return ContatoMapper.toDtoList(contatos);
    }

    public ResponseEntity<ContatoDTO> getById(Long id){
        Contato contato = this.getContatoById(id);

        if(contato == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(ContatoMapper.toDto(contato));
    }

    public ResponseEntity<ContatoDTO> create(ContatoRequest contato){        
        Categoria categoria = this.getCategoriaById(contato.getCategoriaId());
        
        if(categoria == null){
            return ResponseEntity.notFound().build();
        }
        
        Contato novoContato = new Contato(contato, categoria);
        
        Contato contatoCriado = this.contatoRepository.save(novoContato);

        return ResponseEntity.ok().body(ContatoMapper.toDto(contatoCriado));
    }

    public ResponseEntity<Void> delete(Long id){
        Contato contato = this.getContatoById(id);

        if(contato == null){
            return ResponseEntity.notFound().build();
        }

        this.contatoRepository.delete(contato);

        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<ContatoDTO> update(Long id, ContatoRequest novosDados){
        Contato toUpdate = this.getContatoById(id);
        
        if(toUpdate == null){
            return ResponseEntity.notFound().build();
        }
        
        Categoria categoria = novosDados.getCategoriaId() != null? this.getCategoriaById(novosDados.getCategoriaId()) : toUpdate.getCategoria();

        Contato updated = ContatoMapper.toModelOnUpdate(toUpdate, novosDados, categoria);

        return ResponseEntity.ok().body(ContatoMapper.toDto(this.contatoRepository.save(updated)));
    }

    private Categoria getCategoriaById(Long id){
        Optional<Categoria> op = this.categoriaRepository.findById(id);

        if(op.isPresent()){
            return op.get();
        }
        return null;
    }
    
    private Contato getContatoById(Long id){
        Optional<Contato> op = this.contatoRepository.findById(id);

        if(op.isPresent()){
            return op.get();
        }
        return null;
    }
}