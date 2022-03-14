package com.senai.DEVAgro.service;


import com.senai.DEVAgro.model.Funcionario;
import com.senai.DEVAgro.repository.FuncionarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class FuncionarioService {

    FuncionarioRepository funcionarioRepository;


    public List<Funcionario> findAll() {
        return funcionarioRepository.findAll();
    }

    public Funcionario findById(Long id) {
        return funcionarioRepository.getById(id);
    }

    public Funcionario save(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public Funcionario update(Long id, Funcionario funcionario) {
        Funcionario resultUpdate = funcionarioRepository.save(funcionario);
        return resultUpdate;
    }

    public void delete(Long id) {
        funcionarioRepository.deleteById(id);
    }
}
