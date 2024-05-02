package com.pucminas.fpaa.ìnterfaces;

import com.pucminas.fpaa.dtos.ResultadoDTO;
import com.pucminas.fpaa.entity.LoteEnergia;

import java.util.List;

public interface LeilaoSolverBacktrackI {

    ResultadoDTO resolverLeilao(Long empresaId);
}
