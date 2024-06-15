package com.pucminas.fpaa.interfaces;

import com.pucminas.fpaa.dtos.ResultadoDTO;

public interface LeilaoSolverDivisaoEConquistaI {
    ResultadoDTO InicializaLeilao(Long idEmpresa) throws Exception;
}
