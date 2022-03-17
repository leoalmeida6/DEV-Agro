package com.devagro.repository;

import com.devagro.model.Empresa;
import com.devagro.model.Fazenda;
import com.devagro.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    //Endpoint 9
    List<Funcionario> findByEmpresa(Empresa empresa);
/*
    Long countByEmpresa(Empresa empresa);*/
}
