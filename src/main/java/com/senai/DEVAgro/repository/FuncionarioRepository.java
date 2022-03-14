package com.senai.DEVAgro.repository;

import com.senai.DEVAgro.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
