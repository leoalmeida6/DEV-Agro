package com.devagro.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "fazenda")
public class Fazenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String nome;
    @Column(nullable = false, length = 100)
    private String endereco;
    @Column(nullable = false)
    private Integer estoque;
    @Column(nullable = false)
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private String dataUltimaColheita;


    //RELACIONAMENTO

    //Empresa
    @ManyToOne
    @JoinColumn(name = "empresa_id", referencedColumnName = "ID")
    private Empresa empresa;
    @OneToOne
    @JoinColumn(name = "id_grao")
    private Grao grao;

}
