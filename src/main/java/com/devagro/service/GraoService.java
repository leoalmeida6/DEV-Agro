package com.devagro.service;

import com.devagro.model.Empresa;
import com.devagro.model.Fazenda;
import com.devagro.model.Grao;
import com.devagro.repository.GraoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GraoService {

    final GraoRepository graoRepository;

    public GraoService(GraoRepository graoRepository) {
        this.graoRepository = graoRepository;
    }

    public Grao findById(Long id) {

        return graoRepository.getById(id);
    }

    public List<Grao> findAll() {

        return graoRepository.findAll();
    }

    public Grao save(Grao grao) {

        return graoRepository.save(grao);
    }

    public Grao update(Long id, Grao grao) {

        Grao result = graoRepository.save(grao);
        return result;
    }

    public void delete(Long id) {

        graoRepository.deleteById(id);
    }

    //Endpoint 7
    public List<Grao> graoEmpresa(Empresa empresa) {
        return graoRepository.findByEmpresa(empresa);
    }
}
