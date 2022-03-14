package com.senai.DEVAgro.service;

import com.senai.DEVAgro.model.Fazenda;
import com.senai.DEVAgro.repository.FazendaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@AllArgsConstructor
@Service
public class FazendaService {

    FazendaRepository fazendaRepository;


    public List<Fazenda> findAll() {
        return fazendaRepository.findAll();
    }

    public Fazenda findById(Long id) {
        return fazendaRepository.getById(id);
    }

    public Fazenda save(Fazenda fazenda) {
        return fazendaRepository.save(fazenda);
    }

    public Fazenda update(Long id, Fazenda fazenda) {
        Fazenda resultUpdate = fazendaRepository.save(fazenda);
        return resultUpdate;
    }

    public void delete(Long id) {
        fazendaRepository.deleteById(id);
    }
}
