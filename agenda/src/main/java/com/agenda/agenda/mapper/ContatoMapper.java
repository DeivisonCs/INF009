package com.agenda.agenda.mapper;

import java.util.List;

import com.agenda.agenda.dto.ContatoDTO;
import com.agenda.agenda.model.Contato;

public class ContatoMapper {

    public static List<ContatoDTO> toDtoList(List<Contato> contatos){
        return contatos.stream().map(ContatoDTO::new).toList();
    }

    public static ContatoDTO toDto(Contato contato){
        return new ContatoDTO(contato);
    }
}
