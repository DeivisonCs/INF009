package com.prova1.prova.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prova1.prova.dto.PeixeResponse;
import com.prova1.prova.dto.request.PeixeRequest;
import com.prova1.prova.service.PeixeService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/peixe")
public class PeixeController {

    private final PeixeService peixeService;

    public PeixeController(PeixeService peixeService){
        this.peixeService = peixeService;
    }

    @PostMapping
    @Secured("ADMIN_USER")
    public ResponseEntity<Void> register(@RequestBody @Valid PeixeRequest peixe){
        this.peixeService.create(peixe);
        return ResponseEntity.ok().build();
    }
    
    @GetMapping
    public ResponseEntity<List<PeixeResponse>> getAll(){
        return ResponseEntity.ok().body(this.peixeService.getAll());
    }
    
    @DeleteMapping("/{id}")
    @Secured("ADMIN_USER")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        return this.peixeService.delete(id);
    }
    
    @PutMapping("/{id}")
    @Secured("ADMIN_USER")
    public ResponseEntity<PeixeResponse> update(@PathVariable Long id, @RequestBody PeixeRequest peixe){
        return this.peixeService.update(id, peixe);
    }
    

}
