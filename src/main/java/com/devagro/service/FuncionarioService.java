package com.devagro.service;

import com.devagro.model.Empresa;
import com.devagro.model.Funcionario;
import com.devagro.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FuncionarioService {

    final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public Funcionario findById(Long id) {

        return funcionarioRepository.getById(id);
    }

    public List<Funcionario> findAll() {

        return funcionarioRepository.findAll();
    }

    public Funcionario save(Funcionario funcionario) {

        return funcionarioRepository.save(funcionario);
    }

    public Funcionario update(Long id, Funcionario funcionario) {

        Funcionario result = funcionarioRepository.save(funcionario);
        return result;
    }

    public void delete(Long id) {

        funcionarioRepository.deleteById(id);
    }

/*    //Endpoint 9
    public List<Funcionario> funcionarioEmpresa(Empresa empresa) {
        return funcionarioRepository.findByFuncionario(empresa);
    }

    public Long countFuncionarioEmpresa(Empresa empresa) {
        return funcionarioRepository.countByEmpresa(empresa);
    }*/

}