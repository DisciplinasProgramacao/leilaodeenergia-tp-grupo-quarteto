package com.pucminas.fpaa.benchmarking;

import com.pucminas.fpaa.dtos.ResultadoDTO;
import com.pucminas.fpaa.entity.EmpresaInteressada;
import com.pucminas.fpaa.entity.EmpresaVendedora;
import com.pucminas.fpaa.model.LeilaoSolverBacktrack;
import com.pucminas.fpaa.repositories.EmpresaInteressadaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.Random;

@ActiveProfiles("test")
@SpringBootTest
@Sql(scripts = "classpath:data-test.sql")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public class BacktrackingTest {

    @Autowired
    private LeilaoSolverBacktrack backtrackService;

    @Autowired
    private EmpresaInteressadaRepository empresaInteressadaRepository;
    private static final int TEMPO_LIMITE_SEGUNDOS = 30;
    private static final Random RANDOM = new Random(42);

    @Test
    void testBacktrackingPerformance() {
        int tamanhoAtual = 10;
        boolean limiteAlcancado = false;

        while (!limiteAlcancado) {
            List<Double> temposExecucao = new ArrayList<>();

            for (int i = 0; i < 10; i++) {
                limparEmpresasInteressadas();
                if (i == 0) adicionarEmpresasInteressadas(0);
                else adicionarEmpresasInteressadas(tamanhoAtual);

                ResultadoDTO resultado = executarTeste(3L);
                long duracaoSegundos = TimeUnit.NANOSECONDS.toSeconds(resultado.getDuracao());
                temposExecucao.add((double) duracaoSegundos);

                System.out.println("Execução " + (i + 1) + " com tamanho " + tamanhoAtual + ": " + duracaoSegundos + " segundos");
            }

            double mediaDuracao = temposExecucao.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
            System.out.println("Tamanho: " + tamanhoAtual + " - Média de execução: " + mediaDuracao + " segundos");

            if (mediaDuracao > TEMPO_LIMITE_SEGUNDOS) {
                System.out.println("Tempo limite estourado na média com tamanho: " + tamanhoAtual);
                limiteAlcancado = true;
            } else {
                tamanhoAtual++;
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
            System.out.println(empresaInteressada.getQuantRequerida()+"\n");
            empresaInteressadaRepository.save(empresaInteressada);
        }
    }

    private ResultadoDTO executarTeste(Long empresaId) {
        ResultadoDTO resultado = new ResultadoDTO();
        resultado.iniciarContagem();

        try {
            resultado = backtrackService.resolverLeilao(empresaId);
        } finally {
            resultado.finalizarContagem();
        }

        return resultado;
    }
}
