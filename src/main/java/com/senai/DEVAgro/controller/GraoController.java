package com.senai.DEVAgro.controller;

import com.senai.DEVAgro.model.Empresa;
import com.senai.DEVAgro.model.Fazenda;
import com.senai.DEVAgro.model.Grao;
import com.senai.DEVAgro.service.EmpresaService;
import com.senai.DEVAgro.service.GraoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/grao")
public class GraoController {

    GraoService graoService;
    EmpresaService empresaService;

    @PostMapping
    public Grao saveGrao(@RequestBody @Valid Grao grao) {
        return graoService.save(grao);
    }

    //EndPoint 1
    @GetMapping
    public ResponseEntity<List<Grao>> findAllGrao() {
        return ResponseEntity.status(HttpStatus.OK).body(graoService.findAll());
    }

    //Endpoint 7
    @GetMapping(value = "/graoEmpresa/{id}")
    public ResponseEntity<List<Grao>> findByEmpresa(@PathVariable Long id) {
        Empresa empresa = empresaService.findById(id);
        return ResponseEntity.ok().body(graoService.graoEmpresa(empresa));
    }
}
