package com.pucminas.fpaa.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "EMPRESA_INTERESSADA")
@Builder
public class EmpresaInteressada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private int quantRequerida;
    private Double valor; // Valor do lance para o lote de energia

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vendedora_id")
    private EmpresaVendedora empresaVendedora;

    @Override
    public String toString() {
        return "EmpresaInteressada{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
