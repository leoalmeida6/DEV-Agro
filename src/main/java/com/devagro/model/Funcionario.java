package com.devagro.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 40)
    private String nome;
    @Column(nullable = false, length = 40)
    private String sobrenome;
    @CPF
    @Column(nullable = false, unique = true, length = 14)
    @Pattern(regexp = "(^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$)")
    private String cpf;
    @Column(nullable = false, length = 14)
    @Pattern(regexp="^\\([0-9]{2}\\) [0-9]?[0-9]{4}-[0-9]{4}$")
    private String telefone;
    @Column(nullable = false)
    private String sexo;
    @Column(nullable = false, length = 10)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private String dataNascimento;
    @Column(nullable = false, length = 10)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataContratacao = LocalDate.now();


    //RELACIONAMENTO
    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;
}