package com.pucminas.fpaa.model;

import com.pucminas.fpaa.dtos.ResultadoDTO;
import com.pucminas.fpaa.entity.LoteEnergia;
import com.pucminas.fpaa.enums.AlgoritmoEnum;
import com.pucminas.fpaa.repositories.LoteEnergiaRepository;
import com.pucminas.fpaa.ìnterfaces.LeilaoSolverBacktrackI;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LeilaoSolverBacktrack implements LeilaoSolverBacktrackI {

    private final LoteEnergiaRepository loteEnergiaRepository;
    private double melhorLucro;
    private List<LoteEnergia> melhorSelecao;

    public LeilaoSolverBacktrack(LoteEnergiaRepository loteEnergiaRepository) {
        this.loteEnergiaRepository = loteEnergiaRepository;
        this.melhorLucro = 0;
        this.melhorSelecao = new ArrayList<>();
    }

    @Override
    public ResultadoDTO resolverLeilao(Long idEmpresa) {
        ResultadoDTO resultadoDTO = new ResultadoDTO();
        List<LoteEnergia> lotesDisponiveis = loteEnergiaRepository.findByEmpresaId(idEmpresa);
        List<LoteEnergia> selecaoAtual = new ArrayList<>();
        double lucroAtual = 0;
        resultadoDTO.iniciarContagem();
            backtrack(0, lotesDisponiveis, selecaoAtual, lucroAtual);
            resultadoDTO.setMelhorSelecao(melhorSelecao);
            resultadoDTO.setMelhorLucro(melhorLucro);
            resultadoDTO.setAlgoritmoUtilizado(AlgoritmoEnum.BACKTRAKING);
        resultadoDTO.finalizarContagem();
        return resultadoDTO;
    }

    private void backtrack(int indice, List<LoteEnergia> lotesDisponiveis, List<LoteEnergia> selecaoAtual, double lucroAtual) {
        if (indice == lotesDisponiveis.size()) {
            if (lucroAtual > melhorLucro) {
                melhorLucro = lucroAtual;
                melhorSelecao = new ArrayList<>(selecaoAtual);
            }
            return;
        }

        LoteEnergia lote = lotesDisponiveis.get(indice);
        // Verifica se o lote está disponível para seleção
            for (int i = 0; i <= lote.getValor(); i++) {
                if (lote.getTamanho() * i <= lote.getValor()) {
                    selecaoAtual.add(new LoteEnergia(lote.getIdLoteEnergia(), lote.getTamanho(), lote.getValor() * i, lote.getEmpresa()));
                    backtrack(indice + 1, lotesDisponiveis, selecaoAtual, lucroAtual + lote.getValor() * i);
                    selecaoAtual.remove(selecaoAtual.size() - 1);
                }
            }
    }
}
