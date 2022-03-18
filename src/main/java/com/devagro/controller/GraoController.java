package com.devagro.controller;

import com.devagro.model.Empresa;
import com.devagro.model.Fazenda;
import com.devagro.model.Grao;
import com.devagro.service.EmpresaService;
import com.devagro.service.GraoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/grao")
public class GraoController {

    final GraoService graoService;
    final EmpresaService empresaService;

    public GraoController(GraoService graoService, EmpresaService empresaService) {
        this.graoService = graoService;
        this.empresaService = empresaService;
    }

    @PostMapping
    public Grao saveGrao(@RequestBody @Valid Grao grao) {
        return graoService.save(grao);
    }

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

/*    //Endpoint 8
    @GetMapping(value = "/graoEmpresaCresc/{id}")
    public ResponseEntity<List<Grao>> findAllCresc(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(graoService.findAllCresc());
    }*/
}
