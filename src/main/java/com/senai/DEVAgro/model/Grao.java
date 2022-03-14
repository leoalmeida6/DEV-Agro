package com.senai.DEVAgro.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
//@NoArgsConstructor
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

    @OneToOne
    @JoinColumn(name = "id_fazenda")
    private Fazenda fazenda;
}
