package com.pucminas.fpaa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "INTERESSADA")
public class Interessada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_interessada")
    private Long idInteressada;
    @Column(nullable = false)
    private String nome;

    private int quantidadeDesejada;

    public Interessada(String nome, int quantidadeDesejada) {
        this.nome = nome;
        this.quantidadeDesejada = quantidadeDesejada;
    }
}
