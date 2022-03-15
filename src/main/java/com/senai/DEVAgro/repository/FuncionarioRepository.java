package com.senai.DEVAgro.repository;

import com.senai.DEVAgro.model.Empresa;
import com.senai.DEVAgro.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    List<Funcionario> findByEmpresa(Empresa emrpesa);
}
