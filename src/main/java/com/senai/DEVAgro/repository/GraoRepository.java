package com.senai.DEVAgro.repository;

import com.senai.DEVAgro.model.Empresa;
import com.senai.DEVAgro.model.Grao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GraoRepository extends JpaRepository<Grao, Long> {

    List<Grao> findByEmpresa(Empresa empresa);
}
