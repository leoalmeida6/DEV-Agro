package com.devagro.service;

import com.devagro.model.Empresa;
import com.devagro.repository.EmpresaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {

        this.empresaRepository = empresaRepository;
    }

    public Empresa findById(Long id) {
        Optional<Empresa> empresa = empresaRepository.findById(id);
        return empresa.get();
    }

    public List<Empresa> findAll() {

        return empresaRepository.findAll();
    }

    public Empresa save(Empresa empresa) {

        return empresaRepository.save(empresa);
    }

    public Empresa update(Long id, Empresa empresa) {

        Empresa result = empresaRepository.save(empresa);
        return result;
    }

    public void delete(Long id) {

        empresaRepository.deleteById(id);
    }

}
