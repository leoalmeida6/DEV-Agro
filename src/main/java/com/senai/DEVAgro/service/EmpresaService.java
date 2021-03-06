package com.senai.DEVAgro.service;

import com.senai.DEVAgro.model.Empresa;
import com.senai.DEVAgro.repository.EmpresaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class EmpresaService {

    EmpresaRepository empresaRepository;


    public List<Empresa> findAll() {
        return empresaRepository.findAll();
    }

    public Empresa findById(Long id) {
        Optional<Empresa> empresa = empresaRepository.findById(id);
        return empresa.get();
    }

    public Empresa save(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    public Empresa update(Long id, Empresa empresa) {
        Empresa resultUpdate = empresaRepository.save(empresa);
        return resultUpdate;
    }

    public void delete(Long id) {
        empresaRepository.deleteById(id);
    }
}
