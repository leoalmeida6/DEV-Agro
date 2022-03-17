package com.devagro.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;
import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Data
@Entity
@Table(name = "funcionario")
public class Funcionario {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 40)
    private String nome;
    @Column(nullable = false, length = 40)
    private String sobrenome;
    @CPF
    @Column(nullable = false, unique = true, length = 11)
    @Pattern(regexp = "(\\d{2})\\d{4}-\\d{4}$")
    //https://pt.stackoverflow.com/questions/133691/formatar-campo-cpf-ou-cnpj-usando-regex
    private String cpf;
    @Column(nullable = false, length = 12)
    @Pattern(regexp = "^(\\(\\d{2}\\)?\\s?|\\d{2}(\\-|\\s))?\\d{2,4}(\\-|\\s)?\\d{4,5}$")
    private String telefone;
    @Column(nullable = false, length = 1)
    private Character sexo;
    @Column(nullable = false, length = 8)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String dataNascimento;
    @Column(nullable = false, length = 8)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String dataContratacao;


    //RELACIONAMENTO
    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;
}