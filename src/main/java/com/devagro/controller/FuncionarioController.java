package com.devagro.controller;

import com.devagro.model.Empresa;
import com.devagro.model.Funcionario;
import com.devagro.service.EmpresaService;
import com.devagro.service.FuncionarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    final FuncionarioService funcionarioService;
    final EmpresaService empresaService;

    public FuncionarioController(FuncionarioService funcionarioService, EmpresaService empresaService) {
        this.funcionarioService = funcionarioService;
        this.empresaService = empresaService;
    }

    @PostMapping
    public Funcionario saveFuncionario(@RequestBody @Valid Funcionario funcionario) {
        return funcionarioService.save(funcionario);
    }

    @GetMapping
    public ResponseEntity<List<Funcionario>> findAllFuncionario() {
        return ResponseEntity.status(HttpStatus.OK).body(funcionarioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneFuncionario(@PathVariable Long id) {
        Funcionario funcionario = funcionarioService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(funcionarioService.findById(id));
    }

    //Endpoint 9
    @GetMapping(value = "/funcionarioEmpresa/{id}")
    public ResponseEntity<List<Funcionario>> findByEmpresa(@PathVariable Long id) {
        Empresa empresa = empresaService.findById(id);
        return ResponseEntity.ok().body(funcionarioService.funcionarioEmpresa(empresa));
    }

    //Endpoint 10
    @GetMapping(value = "/quantidadeFuncionario/{id}")
    public ResponseEntity<Long> countFuncionarioEmpresa(@PathVariable Long id) {
        Empresa empresa = empresaService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(funcionarioService.countFuncionarioEmpresa(empresa));
    }
}
