package com.devagro.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class GraoDto {

    @NotBlank
    private String nome;
    @NotNull
    private Integer tempoMedioColheita;

}
