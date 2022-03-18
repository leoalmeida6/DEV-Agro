package com.devagro.repository;

import com.devagro.model.Empresa;
import com.devagro.model.Fazenda;
import com.devagro.model.Grao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GraoRepository extends JpaRepository<Grao, Long> {

    //Endpoint 7
    List<Grao> findByEmpresa(Empresa empresa);

/*    //Endpoint 8
    List<Grao> findAllByOrderByIdCresc();*/

    //Endpoint 10
    Long countByEmpresa(Empresa empresa);
}
