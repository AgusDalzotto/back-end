package com.portfolio.portfolio.Security.Dto;

import jakarta.validation.constraints.NotBlank;

public class dtoEducacion {

    @NotBlank
    private String nombreE;
    @NotBlank
    private String descripcionE;
}
