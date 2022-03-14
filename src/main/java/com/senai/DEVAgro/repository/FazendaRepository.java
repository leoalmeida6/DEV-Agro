package com.senai.DEVAgro.repository;

import com.senai.DEVAgro.model.Empresa;
import com.senai.DEVAgro.model.Fazenda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FazendaRepository extends JpaRepository<Fazenda, Long> {

    List<Fazenda> findByEmpresa(Empresa empresa);

    Long countFazenda(Empresa empresa);

}
