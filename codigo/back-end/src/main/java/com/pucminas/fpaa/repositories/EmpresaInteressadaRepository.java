package com.pucminas.fpaa.repositories;

import com.pucminas.fpaa.entity.EmpresaInteressada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpresaInteressadaRepository extends JpaRepository<EmpresaInteressada, Long> {
    List<EmpresaInteressada> findByLoteInteressadoId(Long id);
}
