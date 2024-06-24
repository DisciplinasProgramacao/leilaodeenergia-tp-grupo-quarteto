package com.pucminas.fpaa.Greedy;

import com.pucminas.fpaa.dtos.ResultadoDTO;
import com.pucminas.fpaa.entity.EmpresaInteressada;
import com.pucminas.fpaa.entity.EmpresaVendedora;
import com.pucminas.fpaa.model.LeilaoSolverGreedyValorDesc;
import com.pucminas.fpaa.repositories.EmpresaInteressadaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@ActiveProfiles("test")
@SpringBootTest
@Sql(scripts = "classpath:data-test.sql")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public class GeedyTestPorValorDesc {

    @Autowired
    private LeilaoSolverGreedyValorDesc leilaoSolverGreedy;

    @Autowired
    private EmpresaInteressadaRepository empresaInteressadaRepository;
    private static final int TEMPO_LIMITE_SEGUNDOS = 30;
    private static final Random RANDOM = new Random(42);
    private static final int TAMANHO_INICIO = 76;

    @Test
    void testBacktrackingPerformance() {
        int tamanhoAtual = TAMANHO_INICIO;
        boolean limiteAlcancado = false;
        List<ResultadoDTO> resultadoFinal = new ArrayList<>();
        while (!limiteAlcancado) {
            List<Double> temposExecucao = new ArrayList<>();

            for (int i = 0; i < 10; i++) {
                limparEmpresasInteressadas();
                adicionarEmpresasInteressadas(tamanhoAtual);

                ResultadoDTO resultado = executarTeste(3L);
                long duracaoSegundos = TimeUnit.NANOSECONDS.toSeconds(resultado.getDuracao());
                temposExecucao.add((double) duracaoSegundos);
                resultadoFinal.add(resultado);
                System.out.println("Execução " + (i + 1) + " com tamanho " + tamanhoAtual + ": " + duracaoSegundos + " segundos");
            }

            double mediaDuracao = temposExecucao.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
            System.out.println("Tamanho: " + tamanhoAtual + " - Média de execução: " + mediaDuracao + " segundos");

            if (tamanhoAtual >= TAMANHO_INICIO*10) {
                System.out.println("Tempo limite estourado na média com tamanho: " + tamanhoAtual);
                limiteAlcancado = true;
                System.out.println(resultadoFinal);
            } else {
                tamanhoAtual += TAMANHO_INICIO;
                resultadoFinal.clear();
            }
        }
    }

    private void limparEmpresasInteressadas() {
        empresaInteressadaRepository.deleteAll();
    }

    private void adicionarEmpresasInteressadas(int quantidade) {
        for (int i = 1; i <= quantidade; i++) {
            EmpresaInteressada empresaInteressada = EmpresaInteressada.builder()
                    .nome("Empresa L" + i)
                    .quantRequerida((RANDOM.nextInt(60) + 1) * 10)
                    .valor((double) (100 + RANDOM.nextInt(500)))
                    .empresaVendedora(
                            EmpresaVendedora.builder()
                                    .id(3L)
                                    .nome("Empresa Do Caram")
                                    .quant_vendida(0)
                                    .quant_disponivel(1000)
                                    .build()
                    ).build();
            //System.out.print(empresaInteressada.getQuantRequerida()+" - ");
            empresaInteressadaRepository.save(empresaInteressada);
        }
    }

    private ResultadoDTO executarTeste(Long empresaId) {
        ResultadoDTO resultado = new ResultadoDTO();
        resultado.iniciarContagem();

        try {
            resultado = leilaoSolverGreedy.resolverLeilaoSolverGreedyValorDescI(empresaId);
        } finally {
            resultado.finalizarContagem();
        }

        return resultado;
    }
}
