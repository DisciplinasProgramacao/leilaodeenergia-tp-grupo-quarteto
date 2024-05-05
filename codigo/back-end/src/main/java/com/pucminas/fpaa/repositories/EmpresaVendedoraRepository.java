package com.pucminas.fpaa.repositories;

import com.pucminas.fpaa.entity.EmpresaVendedora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaVendedoraRepository extends JpaRepository<EmpresaVendedora, Long> {
}
