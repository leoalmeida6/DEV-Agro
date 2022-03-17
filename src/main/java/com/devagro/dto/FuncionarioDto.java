package com.devagro.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class FuncionarioDto {

    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank
    private String cpf;
    @NotNull
    @Size(max = 12)
    private String telefone;
    @NotBlank
    private String sexo;
    @NotBlank
    private LocalDate dataNascimento;
    @NotBlank
    private LocalDate dataContratacao;
}