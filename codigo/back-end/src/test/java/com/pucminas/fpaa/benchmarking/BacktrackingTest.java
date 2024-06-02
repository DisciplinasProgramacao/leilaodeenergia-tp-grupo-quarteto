package com.pucminas.fpaa.benchmarking;


import com.pucminas.fpaa.dtos.ResultadoDTO;
import com.pucminas.fpaa.entity.EmpresaInteressada;
import com.pucminas.fpaa.entity.EmpresaVendedora;
import com.pucminas.fpaa.model.LeilaoSolverBacktrack;
import com.pucminas.fpaa.repositories.EmpresaInteressadaRepository;
import com.pucminas.fpaa.repositories.EmpresaVendedoraRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@ActiveProfiles("test")
@SpringBootTest
@Sql(scripts = "classpath:data-test.sql")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public class BacktrackingTest {

    @Autowired
    private  LeilaoSolverBacktrack backtrackService;
    @Autowired
    private  EmpresaInteressadaRepository empresaInteressadaRepository;

    private static final int TEMPO_LIMITE_SEGUNDOS = 30;


    @Test
    void testBacktrackingPerformance() {
        int maxTamanho=1;
        boolean limiteAlcancado = false;
        List<Double> temposExecucao = new ArrayList<>();

        while (!limiteAlcancado) {

            ResultadoDTO resultadoDTO = executarTeste(3L);
            long duracaoSegundos = TimeUnit.NANOSECONDS.toSeconds(resultadoDTO.getDuracao());
            temposExecucao.add((double) duracaoSegundos);

            if(duracaoSegundos > TEMPO_LIMITE_SEGUNDOS) {
                limiteAlcancado = true;
                System.out.println("Tempo de limite estourado na execução: "+ maxTamanho + " com tamanho: "+ (maxTamanho + 10));
                break;
            }
            adicionarEmpresasInteressadas(maxTamanho++);
        }
        if(limiteAlcancado) {
            double mediaDuracao = temposExecucao.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
            System.out.println("Tamanho: " + (maxTamanho + 10) + " - Média de execução: " + mediaDuracao + " segundos");

        }
    }

    private void adicionarEmpresasInteressadas(int quantidade) {
            EmpresaInteressada empresaInteressada = EmpresaInteressada.builder()
                    .nome("Empresa L" + quantidade)
                    .quantRequerida((100 % quantidade) * 10)
                    .valor((double) (100 + quantidade * 10))
                    .empresaVendedora(
                            EmpresaVendedora.builder()
                                    .id(3L)
                                    .nome("Empresa Do Caram")
                                    .quant_vendida(0)
                                    .quant_disponivel(1000)
                                    .build()
                    ).build();
            empresaInteressadaRepository.save(empresaInteressada);
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

