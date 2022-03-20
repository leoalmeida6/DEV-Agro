package com.devagro.service;

import com.devagro.model.Empresa;
import com.devagro.model.Fazenda;
import com.devagro.repository.FazendaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FazendaService {

    final FazendaRepository fazendaRepository;

    public FazendaService(FazendaRepository fazendaRepository) {
        this.fazendaRepository = fazendaRepository;
    }

    public Fazenda findById(Long id) {

        return fazendaRepository.getById(id);
    }

    public List<Fazenda> findAll() {

        return fazendaRepository.findAll();
    }

    public Fazenda save(Fazenda fazenda) {

        return fazendaRepository.save(fazenda);
    }

    public Fazenda update(Long id, Fazenda fazenda) {
        Fazenda result = fazendaRepository.save(fazenda);
        return result;
    }

    public void delete(Long id) {

        fazendaRepository.deleteById(id);
    }

    //Endpoint 2
    public List<Fazenda> fazendaEmpresa(Empresa empresa) {
        return fazendaRepository.findByEmpresa(empresa);
    }

    //Endpoint 3
    public Long countFazendaEmpresa(Empresa empresa) {
        return fazendaRepository.countByEmpresa(empresa);
    }
}