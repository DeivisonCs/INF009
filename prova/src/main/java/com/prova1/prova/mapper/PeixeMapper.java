package com.prova1.prova.mapper;

import java.util.List;

import com.prova1.prova.dto.PeixeResponse;
import com.prova1.prova.dto.request.PeixeRequest;
import com.prova1.prova.model.Peixe;

public class PeixeMapper {

    public static Peixe requestToModel(PeixeRequest peixe){
        return new Peixe(peixe);
    }

    public static List<PeixeResponse> toDtoList(List<Peixe> peixes){
        return peixes.stream().map(PeixeResponse::new).toList();
    }

    public static PeixeResponse modelToResponse(Peixe peixe){
        return new PeixeResponse(peixe);
    }

    // public static Peixe fishUpdate(Peixe oldOne, PeixeRequest newOne){
    //     return Peixe.builder()
    //         .nome(newOne.getNome()!=null? newOne.getNome() : oldOne.getNome())
    //         .especie(newOne.getEspecie()!=null? newOne.getEspecie() : oldOne.getEspecie())
    //         .preco(newOne.getPreco()!=null? newOne.getPreco() : oldOne.getPreco())
    //         .quantidadeEmEstoque(newOne.getQuantidadeEmEstoque()!=null? newOne.getQuantidadeEmEstoque() : oldOne.getQuantidadeEmEstoque())
    //         .build();
    // }
}
