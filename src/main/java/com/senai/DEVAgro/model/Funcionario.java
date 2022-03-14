package com.senai.DEVAgro.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    @Pattern(regexp = "^\\([1-9]{2}\\)[0-9]{4,5}-[0-9]{4}/")
    private String telefone;
    @Column(nullable = false, length = 1)
    private Character sexo;
    @Column(nullable = false, length = 8)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private String dataNascimento;
    @Column(nullable = false, length = 8)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private String dataContratacao;


    //RELACIONAMENTO
    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;
}
