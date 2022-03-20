package com.devagro.controller;

import com.devagro.model.Empresa;
import com.devagro.model.Fazenda;
import com.devagro.service.EmpresaService;
import com.devagro.service.FazendaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/fazenda")
public class FazendaController {

    final FazendaService fazendaService;
    final EmpresaService empresaService;

    public FazendaController(FazendaService fazendaService, EmpresaService empresaService) {
        this.fazendaService = fazendaService;
        this.empresaService = empresaService;
    }

    @PostMapping
    public Fazenda saveFazenda(@RequestBody @Valid Fazenda fazenda) {
        return fazendaService.save(fazenda);
    }

    @GetMapping
    public ResponseEntity<List<Fazenda>> findAllFazenda() {
        return ResponseEntity.status(HttpStatus.OK).body(fazendaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fazenda> findById(@PathVariable Long id) {
        Fazenda fazenda = fazendaService.findById(id);
        return ResponseEntity.ok().body(fazenda);
    }

    //Endpoint 2
    @GetMapping(value = "/fazendaEmpresa/{id}")
    public ResponseEntity<List<Fazenda>> findByEmpresa(@PathVariable Long id) {
        Empresa empresa = empresaService.findById(id);
        return ResponseEntity.ok().body(fazendaService.fazendaEmpresa(empresa));
    }

    //Endpoint 3
    @GetMapping(value = "/quantidadeFazenda/{id}")
    public ResponseEntity<Long> countFazendaEmpresa(@PathVariable Long id) {
        Empresa empresa = empresaService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(fazendaService.countFazendaEmpresa(empresa));
    }

    //Endpoint 4


    //Endpoint 5
    @PutMapping(value = "/adicionaEstoque/{id}/{quantidade}")
    public ResponseEntity<Fazenda> insertEstoque(@PathVariable @Valid Long id, @PathVariable Integer quantidade) {

        Fazenda fazenda = fazendaService.findById(id);
        Integer estoqueAtual = fazenda.getEstoque();
        fazenda.setEstoque(estoqueAtual + quantidade);
        Fazenda updateEmpresa = fazendaService.update(id, fazenda);
        return ResponseEntity.status(HttpStatus.OK).body(updateEmpresa);
    }

    //Endpoint 6
    @PutMapping(value = "/removeEstoque/{id}/{quantidade}")
    public ResponseEntity<Fazenda> deleteEstoque(@PathVariable @Valid Long id, @PathVariable Integer quantidade) {

        Fazenda fazenda = fazendaService.findById(id);
        Integer estoqueAtual = fazenda.getEstoque();
        fazenda.setEstoque(estoqueAtual - quantidade);
        Fazenda updateEmpresa = fazendaService.update(id, fazenda);
        return ResponseEntity.status(HttpStatus.OK).body(updateEmpresa);
    }
}