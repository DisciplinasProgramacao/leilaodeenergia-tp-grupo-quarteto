package com.pucminas.fpaa.repositories;

import com.pucminas.fpaa.entity.EmpresaEnergia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaEnergiaRepository extends JpaRepository<EmpresaEnergia, Long> {
}
