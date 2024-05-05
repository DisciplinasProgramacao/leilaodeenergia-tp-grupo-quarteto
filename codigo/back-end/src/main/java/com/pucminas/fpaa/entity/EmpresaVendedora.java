package com.pucminas.fpaa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "EMPRESA_VENDEDORA")
public class EmpresaVendedora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int quantidadeDisponivel;

    @OneToMany
    @JoinColumn(name = "empresa_vendedora_id", referencedColumnName = "id")
    @JsonIgnore
    private List<LoteEnergia> lotes;
}
