package com.devagro.controller;

import com.devagro.dto.FuncionarioDto;
import com.devagro.model.Empresa;
import com.devagro.model.Funcionario;
import com.devagro.service.EmpresaService;
import com.devagro.service.FuncionarioService;
import org.springframework.beans.BeanUtils;
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
    public ResponseEntity<Object> saveFuncionario(@RequestBody @Valid FuncionarioDto funcionarioDto) {
        var funcionarioModel = new Funcionario();
        BeanUtils.copyProperties(funcionarioDto, funcionarioModel); //Conversão dos arquivos DTO para Model
        return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioService.save(funcionarioModel));
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

/*    //Endpoint 10
    @GetMapping(value = "/quantidadeFuncionario/{id}")
    public ResponseEntity<Long> countFuncionarioEmpresa(@PathVariable Long id) {
        Empresa empresa = empresaService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(funcionarioService.countFuncionarioEmpresa(empresa));
    }*/
}
