package com.devagro.controller;

import com.devagro.dto.EmpresaDto;
import com.devagro.model.Empresa;
import com.devagro.model.Fazenda;
import com.devagro.service.EmpresaService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    final EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {

        this.empresaService = empresaService;
    }

/*    @PostMapping
    public ResponseEntity<Empresa> saveEmpresa(@RequestBody @Valid EmpresaDto empresaDto) {
        var empresaModel = new Empresa();
        BeanUtils.copyProperties(empresaDto, empresaModel); //Conversão dos arquivos DTO para Model
        return ResponseEntity.status(HttpStatus.CREATED).body(empresaService.save(empresaModel));
    }*/

    @PostMapping
    public Empresa saveEmpresa(@RequestBody @Valid Empresa empresa) {
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