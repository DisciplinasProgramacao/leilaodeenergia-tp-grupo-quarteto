package com.pucminas.fpaa.repositories;

import com.pucminas.fpaa.entity.LoteEnergia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoteEnergiaRepository extends JpaRepository<LoteEnergia,Long> {
    @Query("SELECT l FROM LoteEnergia l WHERE l.empresa.idEmpresa = :empresaId")
    List<LoteEnergia> findByEmpresaId(@Param("empresaId") Long empresaId);
}
