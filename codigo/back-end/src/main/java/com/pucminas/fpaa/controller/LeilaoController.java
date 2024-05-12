package com.pucminas.fpaa.controller;

import com.pucminas.fpaa.dtos.ResultadoDTO;
import com.pucminas.fpaa.ìnterfaces.LeilaoSolverBacktrackI;
import com.pucminas.fpaa.ìnterfaces.LeilaoSolverGreedyI;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class LeilaoController {
    private final LeilaoSolverBacktrackI backtrackI;
    private final LeilaoSolverGreedyI greedyI;


    public LeilaoController(LeilaoSolverBacktrackI backtrackI, LeilaoSolverGreedyI greedyI) {
        this.backtrackI = backtrackI;
        this.greedyI = greedyI;
    }

    @GetMapping("/backtracking/{empresaId}")
    public ResultadoDTO getBacktracking(@PathVariable Long empresaId) {
        return backtrackI.resolverLeilao(empresaId);
    }

    @GetMapping("/greedy/{empresaId}")
    public ResultadoDTO getGreedy(@PathVariable Long empresaId) {
        return greedyI.resolverLeilaoGreedy(empresaId);
    }
}
