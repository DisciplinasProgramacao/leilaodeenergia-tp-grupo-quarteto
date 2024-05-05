package com.pucminas.fpaa.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "LOTE_ENERGIA")
public class LoteEnergia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int tamanho;

    @ManyToOne
    @JoinColumn(name = "empresa_vendedora_id", referencedColumnName = "id")
    private EmpresaVendedora empresaVendedora;

    @OneToOne
    @JoinColumn(name = "empresa_compradora_id", referencedColumnName = "id", nullable = true)
    @JsonIgnoreProperties("loteInteressado")
    private EmpresaInteressada empresaCompradora;
}