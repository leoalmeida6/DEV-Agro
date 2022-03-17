package com.devagro.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "grao")
public class Grao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 40)
    private String nome;
    @Column(nullable = false)
    private Integer tempoMedioColheita;

    //RELACIONAMENTO
    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;
}
