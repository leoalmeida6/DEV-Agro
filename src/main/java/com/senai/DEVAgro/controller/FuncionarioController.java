package com.senai.DEVAgro.controller;

import com.senai.DEVAgro.model.Empresa;
import com.senai.DEVAgro.model.Funcionario;
import com.senai.DEVAgro.service.EmpresaService;
import com.senai.DEVAgro.service.FuncionarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    FuncionarioService funcionarioService;
    EmpresaService empresaService;

    @PostMapping
    Funcionario saveFuncionario(@RequestBody @Valid Funcionario funcionario){
        return funcionarioService.save(funcionario);
    }

    @GetMapping
    public ResponseEntity<List<Funcionario>> findAllFuncionario(){
        return ResponseEntity.status(HttpStatus.OK).body(funcionarioService.findAll());
    }

    @GetMapping(value = "/funcionarioEmpresa/{id}")
    public ResponseEntity<List<Funcionario>> findByFuncionario(@PathVariable Long id){
        Empresa empresa = empresaService.findById(id);
        return ResponseEntity.ok().body(funcionarioService.funcionarioEmpresa(empresa));
    }
}
