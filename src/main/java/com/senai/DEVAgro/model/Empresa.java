package com.senai.DEVAgro.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "empresa")
public class Empresa {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String nome;
    @Column(nullable = false, unique = true, length = 18)
    @Pattern(regexp = "(^\\d{2}.\\d{3}.\\d{3}/\\d{4}-\\d{2}$)")
    // https://pt.stackoverflow.com/questions/133691/formatar-campo-cpf-ou-cnpj-usando-regex
    private String cnpj;
    @Column(nullable = false, length = 100)
    private String endereco;
}
