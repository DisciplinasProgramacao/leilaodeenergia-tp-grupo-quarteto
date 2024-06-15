package com.pucminas.fpaa.controller;

import com.pucminas.fpaa.dtos.ResultadoDTO;
/*import com.pucminas.fpaa.ìnterfaces.LeilaoSolverBacktrackI;*/
import com.pucminas.fpaa.interfaces.LeilaoSolverBacktrackI;
import com.pucminas.fpaa.interfaces.LeilaoSolverDivisaoEConquistaI;
import com.pucminas.fpaa.interfaces.LeilaoSolverGreedyI;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class LeilaoController {
    private final LeilaoSolverBacktrackI backtrackI;
    private final LeilaoSolverGreedyI greedyI;
    private final LeilaoSolverDivisaoEConquistaI divisaoEConquistaI;

    public LeilaoController(LeilaoSolverBacktrackI backtrackI,
                            LeilaoSolverGreedyI greedyI,
                            LeilaoSolverDivisaoEConquistaI divisaoEConquistaI) {
        this.backtrackI = backtrackI;
        this.greedyI = greedyI;
        this.divisaoEConquistaI = divisaoEConquistaI;
    }

    @GetMapping("/backtracking/{empresaId}")
    public ResultadoDTO getBacktracking(@PathVariable Long empresaId) {
        return backtrackI.resolverLeilao(empresaId);
    }
    @GetMapping("/greedy/{empresaId}")
    public ResultadoDTO getGreedy(@PathVariable Long empresaId) {
        return greedyI.resolverLeilaoGreedy(empresaId);
    }

    @GetMapping("/divisao-e-conquista/{empresaId}")
    public ResultadoDTO getDivisaoEConquista(@PathVariable Long empresaId){
        try{
            return divisaoEConquistaI.InicializaLeilao(empresaId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
