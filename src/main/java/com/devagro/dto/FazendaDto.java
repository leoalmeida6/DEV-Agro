package com.devagro.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
/*@AllArgsConstructor
@NoArgsConstructor*/
public class FazendaDto {

    @NotBlank
    private String nome;
    @NotNull
    @Size(max = 100)
    private String endereco;
    @NotNull
    private Integer estoque;
    @NotBlank
    private String dataUltimaColheita;

}

