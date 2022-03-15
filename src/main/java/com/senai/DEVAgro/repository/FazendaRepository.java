package com.senai.DEVAgro.repository;

import com.senai.DEVAgro.model.Empresa;
import com.senai.DEVAgro.model.Fazenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FazendaRepository extends JpaRepository<Fazenda, Long> {

    List<Fazenda> findByEmpresa(Empresa empresa);


    /*    Long countFazenda(Long id);*/

}
