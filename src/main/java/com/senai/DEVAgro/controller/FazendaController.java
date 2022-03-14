package com.senai.DEVAgro.controller;

import com.senai.DEVAgro.model.Empresa;
import com.senai.DEVAgro.model.Fazenda;
import com.senai.DEVAgro.service.EmpresaService;
import com.senai.DEVAgro.service.FazendaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/fazenda")
public class FazendaController {

    FazendaService fazendaService;
    EmpresaService empresaService;

    //Endpoint 2
    @PostMapping
    public Fazenda saveFazenda(@RequestBody @Valid Fazenda fazenda) {
        return fazendaService.save(fazenda);
    }

    @GetMapping
    public ResponseEntity<List<Fazenda>> findAllFazenda() {
        return ResponseEntity.status(HttpStatus.OK).body(fazendaService.findAll());
    }

    @GetMapping(value = "/fazendaEmpresa/{id}")
    public ResponseEntity<List<Fazenda>> findByEmpresa(@PathVariable Long id) {
        Empresa empresa = empresaService.findById(id);
        return ResponseEntity.ok().body(fazendaService.fazendaEmpresa(empresa));
    }

    //Endpoint 3
/*    @GetMapping(value = "/quantideFazenda/{id}")
    public ResponseEntity<Long> countAllFazenda(@PathVariable Long id) {
        Empresa empresa = empresaService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(fazendaService.countAllFazenda(empresa));
    }*/
}
