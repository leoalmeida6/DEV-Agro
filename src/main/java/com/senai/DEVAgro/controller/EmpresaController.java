package com.senai.DEVAgro.controller;

import com.senai.DEVAgro.model.Empresa;
import com.senai.DEVAgro.service.EmpresaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    final EmpresaService empresaService;

    @PostMapping
    public Empresa saveFazenda(@RequestBody @Valid Empresa empresa) {
        return empresaService.save(empresa);
    }

    //EndPoint 1
    @GetMapping
    public ResponseEntity<List<Empresa>> findAllEmpresa() {
        return ResponseEntity.status(HttpStatus.OK).body(empresaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> findById(@PathVariable Long id) {
        Empresa empresa = empresaService.findById(id);
        return ResponseEntity.ok().body(empresa);
    }

}
