package com.senai.DEVAgro.repository;

import com.senai.DEVAgro.model.Grao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GraoRepository extends JpaRepository<Grao, Long> {
}
