package com.fiap.restapi.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Professor {
    private Long id;
    private String nome;
    private String departamento;
    private String email;
    private String titulacao;
}
