package com.pucminas.fpaa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "EMPRESA_VENDEDORA")
@Builder
public class EmpresaVendedora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private int quant_disponivel;
    @Column(nullable = false)
    private int quant_vendida;
}
