package com.pucminas.fpaa.controller;

import com.pucminas.fpaa.dtos.ResultadoDTO;
/*import com.pucminas.fpaa.ìnterfaces.LeilaoSolverBacktrackI;*/
import com.pucminas.fpaa.interfaces.LeilaoSolverBacktrackI;
import com.pucminas.fpaa.interfaces.LeilaoSolverDivisaoEConquistaI;
import com.pucminas.fpaa.interfaces.LeilaoSolverGreedyI;
import com.pucminas.fpaa.interfaces.LeilaoSolverGreedyValorTotalI;
import com.pucminas.fpaa.interfaces.LeilaoSolverProgramacaoDinamicaI;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class LeilaoController {
    private final LeilaoSolverBacktrackI backtrackI;
    private final LeilaoSolverGreedyI greedy;
    private final LeilaoSolverGreedyValorTotalI greedyI;
    private final LeilaoSolverDivisaoEConquistaI divisaoEConquistaI;
    private final LeilaoSolverProgramacaoDinamicaI programacaoDinamicaI;

    public LeilaoController(LeilaoSolverBacktrackI backtrackI,
                            LeilaoSolverGreedyI greedy,
                            LeilaoSolverGreedyValorTotalI greedyI,
                            LeilaoSolverDivisaoEConquistaI divisaoEConquistaI,
                            LeilaoSolverProgramacaoDinamicaI programacaoDinamicaI) {
        this.backtrackI = backtrackI;
        this.greedy = greedy;
        this.greedyI = greedyI;
        this.divisaoEConquistaI = divisaoEConquistaI;
        this.programacaoDinamicaI = programacaoDinamicaI;
    }

    @GetMapping("/backtracking/{empresaId}")
    public ResultadoDTO getBacktracking(@PathVariable Long empresaId) {
        return backtrackI.resolverLeilao(empresaId);
    }

    @GetMapping("/greedy/{empresaId}")
    public ResultadoDTO getGreedy(@PathVariable Long empresaId) {
        return greedy.resolverLeilaoGreedy(empresaId);
    }

    @GetMapping("/greedy1/{empresaId}")
    public ResultadoDTO getGreedy1(@PathVariable Long empresaId) {
        return greedyI.resolverLeilaoSolverGreedyValorTotalI(empresaId);
    }

    @GetMapping("/divisao-e-conquista/{empresaId}")
    public ResultadoDTO getDivisaoEConquista(@PathVariable Long empresaId) {
        try {
            return divisaoEConquistaI.InicializaLeilao(empresaId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @GetMapping("/programacao-dinamica/{empresaId}")
    public ResultadoDTO getProgramacaoDinamica(@PathVariable Long empresaId) {
        return programacaoDinamicaI.resolverLeilaoProgramacaoDinamica(empresaId);
    }
}
