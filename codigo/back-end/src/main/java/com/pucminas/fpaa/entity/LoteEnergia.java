package com.pucminas.fpaa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "LOTE_ENERGIA")
public class LoteEnergia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lote_energia")
    private Long idLoteEnergia;
    private int tamanho;
    private double valor;
    @ManyToOne
    @JoinColumn(name = "empresa_id", referencedColumnName = "id_empresa", nullable = false)
    private EmpresaEnergia empresa;

    public LoteEnergia(Long id, int tamanho, double valor, EmpresaEnergia empresa) {
        this.idLoteEnergia = id;
        this.tamanho = tamanho;
        this.valor = valor;
        this.empresa = empresa;
    }
}