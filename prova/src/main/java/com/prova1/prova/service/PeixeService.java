package com.prova1.prova.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.prova1.prova.dto.PeixeResponse;
import com.prova1.prova.dto.request.PeixeRequest;
import com.prova1.prova.mapper.PeixeMapper;
import com.prova1.prova.model.Peixe;
import com.prova1.prova.repository.PeixeRepository;

@Service
public class PeixeService {

    private final PeixeRepository peixeRepository;
    
    public PeixeService(PeixeRepository peixeRepository){
        this.peixeRepository = peixeRepository;
    }

    public void create(PeixeRequest peixe){
        this.peixeRepository.save(PeixeMapper.requestToModel(peixe));
    }

    public List<PeixeResponse> getAll(){
        List<Peixe> peixes = this.peixeRepository.findAll();
        List<PeixeResponse> response = peixes.stream().map(PeixeResponse::new).toList();

        return response;
    }

    public ResponseEntity<Void> delete(Long id){
        Peixe peixe = this.getById(id);

        if(peixe == null){
            return ResponseEntity.notFound().build();
        }

        this.peixeRepository.delete(peixe);

        return ResponseEntity.ok().build();
    }

    public ResponseEntity<PeixeResponse> update(Long id, PeixeRequest newData){
        Peixe fishToUpdate = this.getById(id);

        if(fishToUpdate==null){
            return ResponseEntity.notFound().build();
        }

        // fishToUpdate = PeixeMapper.fishUpdate(fishToUpdate, newData);
        Peixe updatedFish = new Peixe(fishToUpdate, newData);
    
        this.peixeRepository.save(updatedFish);
        return ResponseEntity.ok().body(PeixeMapper.modelToResponse(updatedFish));
    }

    private Peixe getById(Long id){
        Optional<Peixe> op = this.peixeRepository.findById(id);

        if(op.isPresent()){
            return op.get();
        }

        return null;
    }
}
