package com.agenda.agenda.mapper;

import java.util.List;

import com.agenda.agenda.dto.ContatoDTO;
import com.agenda.agenda.dto.request.ContatoRequest;
import com.agenda.agenda.model.Categoria;
import com.agenda.agenda.model.Contato;

public class ContatoMapper {

    public static List<ContatoDTO> toDtoList(List<Contato> contatos){
        return contatos.stream().map(ContatoDTO::new).toList();
    }

    public static ContatoDTO toDto(Contato contato){
        return new ContatoDTO(contato);
    }

    public static Contato toModelOnUpdate(Contato atual, ContatoRequest novosDados, Categoria categoria){
        return Contato.builder()
                .id(atual.getId())
                .nome(novosDados.getNome()!=null? novosDados.getNome(): atual.getNome())
                .telefone(novosDados.getTelefone()!=null? novosDados.getTelefone(): atual.getTelefone())
                .email(novosDados.getEmail()!=null? novosDados.getEmail(): atual.getEmail())
                .categoria(categoria)
                .build();
    }
}
