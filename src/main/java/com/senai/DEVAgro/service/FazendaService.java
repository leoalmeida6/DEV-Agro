package com.senai.DEVAgro.service;

import com.senai.DEVAgro.model.Empresa;
import com.senai.DEVAgro.model.Fazenda;
import com.senai.DEVAgro.repository.FazendaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class FazendaService {

    FazendaRepository fazendaRepository;

    public Fazenda findById(Long id) {

        return fazendaRepository.getById(id);
    }

    public  List<Fazenda> findAll(){
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

    public List<Fazenda> fazendaEmpresa(Empresa empresa) {
        return fazendaRepository.findByEmpresa(empresa);
    }

/*    public Long countAllFazenda(Empresa empresa) {
        return fazendaRepository.countFazenda(empresa.getId());
    }*/
}