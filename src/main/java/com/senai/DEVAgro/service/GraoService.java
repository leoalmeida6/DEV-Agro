package com.senai.DEVAgro.service;

import com.senai.DEVAgro.model.Empresa;
import com.senai.DEVAgro.model.Grao;
import com.senai.DEVAgro.repository.GraoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class GraoService {

    GraoRepository graoRepository;

    public List<Grao> findAll() {
        return graoRepository.findAll();
    }

    public Grao findById(Long id) {
        return graoRepository.getById(id);
    }

    public Grao save(Grao grao) {
        return graoRepository.save(grao);
    }

    public Grao update(Long id, Grao grao) {
        Grao resultUpdate = graoRepository.save(grao);
        return resultUpdate;
    }

    public void delete(Long id) {
        graoRepository.deleteById(id);
    }

    public List<Grao> graoEmpresa(Empresa empresa) {

        return graoRepository.findByEmpresa(empresa);
    }
}
