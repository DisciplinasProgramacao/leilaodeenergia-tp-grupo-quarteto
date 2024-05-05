package com.pucminas.fpaa.repositories;

import com.pucminas.fpaa.entity.EmpresaInteressada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpresaInteressadaRepository extends JpaRepository<EmpresaInteressada, Long> {
    List<EmpresaInteressada> findByLoteInteressadoId(Long id);
    @Query("SELECT ei FROM EmpresaInteressada ei INNER JOIN ei.loteInteressado le " +
            "WHERE le.empresaCompradora IS NULL AND le.empresaVendedora.id = :idEmpresa")
    List<EmpresaInteressada> findAllByLoteInteressadoEmpresaCompradoraIsNullAndEmpresaVendedoraId(@Param("idEmpresa") Long idEmpresa);
}
