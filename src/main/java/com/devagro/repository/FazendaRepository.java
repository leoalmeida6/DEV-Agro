package com.devagro.repository;

import com.devagro.model.Empresa;
import com.devagro.model.Fazenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FazendaRepository extends JpaRepository<Fazenda, Long> {

    //Endpoint 2
    List<Fazenda> findByEmpresa(Empresa empresa);

    //Endpoint 3
    Long countByEmpresa(Empresa empresa);
}