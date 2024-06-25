package com.pucminas.fpaa.model;

import com.pucminas.fpaa.dtos.ResultadoDTO;
import com.pucminas.fpaa.entity.EmpresaInteressada;
import com.pucminas.fpaa.entity.EmpresaVendedora;
import com.pucminas.fpaa.enums.AlgoritmoEnum;
import com.pucminas.fpaa.interfaces.LeilaoSolverProgramacaoDinamicaI;
import com.pucminas.fpaa.repositories.EmpresaInteressadaRepository;
import com.pucminas.fpaa.repositories.EmpresaVendedoraRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LeilaoSolverProgramacaoDinamica implements LeilaoSolverProgramacaoDinamicaI {

    private final EmpresaVendedoraRepository empresaVendedoraRepository;
    private final EmpresaInteressadaRepository empresaInteressadaRepository;

    public LeilaoSolverProgramacaoDinamica(EmpresaVendedoraRepository empresaVendedoraRepository, EmpresaInteressadaRepository empresaInteressadaRepository) {
        this.empresaVendedoraRepository = empresaVendedoraRepository;
        this.empresaInteressadaRepository = empresaInteressadaRepository;
    }

    @Override
    public ResultadoDTO resolverLeilaoProgramacaoDinamica(Long idEmpresa) {

        EmpresaVendedora empresaVendedora = empresaVendedoraRepository.findById(idEmpresa).orElseThrow(() -> new RuntimeException("Empresa não encontrada"));
        List<EmpresaInteressada> interessadas = empresaInteressadaRepository.findByEmpresaVendedoraId(idEmpresa);
        ResultadoDTO resultadoDTO = new ResultadoDTO();

        int quantidadeTotal = empresaVendedora.getQuant_disponivel();
        int n = interessadas.size();

        int[] pesos = interessadas.stream().mapToInt(EmpresaInteressada::getQuantRequerida).toArray();
        int[] valores = interessadas.stream().mapToInt(interessada -> interessada.getValor().intValue()).toArray();

        // Inicializar a tabela de DP
        int[][] dp = new int[n + 1][quantidadeTotal + 1];
        resultadoDTO.iniciarContagem();

        // Construir a tabela de DP
        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= quantidadeTotal; w++) {
                if (pesos[i - 1] <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - pesos[i - 1]] + valores[i - 1]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        int w = quantidadeTotal;
        List<EmpresaInteressada> interessadasSelecionadas = new ArrayList<>();
        for (int i = n; i > 0 && w > 0; i--) {
            if (dp[i][w] != dp[i - 1][w]) {
                interessadasSelecionadas.add(interessadas.get(i - 1));
                w -= pesos[i - 1];
            }
        }
        int quantidadeVendida = interessadasSelecionadas.stream().mapToInt(EmpresaInteressada::getQuantRequerida).sum();
        int valorTotal = dp[n][quantidadeTotal];

        resultadoDTO.finalizarContagem();
        resultadoDTO.setQuantidadeVendida(quantidadeVendida);
        resultadoDTO.setMelhorLucro(valorTotal);
        resultadoDTO.setMelhorSelecao(interessadasSelecionadas);
        resultadoDTO.setAlgoritmoUtilizado(AlgoritmoEnum.PROGRAMACAODINAMICA);

        return resultadoDTO;
    }
}