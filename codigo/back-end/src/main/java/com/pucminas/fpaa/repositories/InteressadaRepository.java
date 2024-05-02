package com.pucminas.fpaa.repositories;

import com.pucminas.fpaa.entity.Interessada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InteressadaRepository extends JpaRepository<Interessada, Long> {
}
