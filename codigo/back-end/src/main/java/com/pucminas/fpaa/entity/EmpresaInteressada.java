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
@Table(name = "EMPRESA_INTERESSADA")
public class EmpresaInteressada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Double lance; // Valor do lance para o lote de energia

    @OneToOne
    @JoinColumn(name = "lote_energia_id", referencedColumnName = "id", nullable = false)
    @JsonIgnoreProperties("empresaCompradora")
    private LoteEnergia loteInteressado;

}
