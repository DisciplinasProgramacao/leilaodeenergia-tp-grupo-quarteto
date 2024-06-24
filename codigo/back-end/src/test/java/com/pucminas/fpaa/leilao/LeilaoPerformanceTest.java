package com.pucminas.fpaa.leilao;

import com.pucminas.fpaa.dtos.ResultadoDTO;
import com.pucminas.fpaa.entity.EmpresaInteressada;
import com.pucminas.fpaa.entity.EmpresaVendedora;
import com.pucminas.fpaa.model.*;
import com.pucminas.fpaa.repositories.EmpresaInteressadaRepository;
import org.junit.jupiter.api.BeforeAll;
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
public class LeilaoPerformanceTest {

    @Autowired
    private LeilaoSolverBacktrack backtrackService;

    @Autowired
    private LeilaoSolverDivisaoEConquista divisaoEConquista;

    @Autowired
    private LeilaoSolverProgramacaoDinamica programacaoDinamica;

    @Autowired
    private LeilaoSolverGreedyUnitario greedyUnitario;

    @Autowired
    private LeilaoSolverGreedyValorDesc greedyValorDesc;

    @Autowired
    private EmpresaInteressadaRepository empresaInteressadaRepository;

    private static List<EmpresaInteressada> empresas;

    private static final Random RANDOM = new Random(42);

    private static final int TAMANHO_INICIAL = 10;
    private static final int TAMANHO_MAXIMO_BACKTRACK = 76;
    private static final int TAMANHO_MAXIMO_DIVISAO_E_CONQUISTA = 76;
    private static final int TAMANHO_MAXIMO_PROGRAMACAO_DINAMICA = 760; // 76 * 10

    @BeforeAll
    public static void setUp() {
        empresas = gerarEmpresasInteressadas(TAMANHO_MAXIMO_PROGRAMACAO_DINAMICA); // Gera para o maior tamanho necessário
    }

    @Test
    void testBacktrackingPerformance() {
        testarPerformance(backtrackService, TAMANHO_MAXIMO_BACKTRACK);
    }

    @Test
    void testDivisaoEConquistaPerformance() {
        testarPerformance(divisaoEConquista, TAMANHO_MAXIMO_DIVISAO_E_CONQUISTA);
    }

    @Test
    void testGuloso1() {
        testarPerformance(greedyUnitario, TAMANHO_MAXIMO_PROGRAMACAO_DINAMICA);
    }

    @Test
    void testGuloso2() {
        testarPerformance(greedyValorDesc, TAMANHO_MAXIMO_PROGRAMACAO_DINAMICA);
    }

    @Test
    void testProgramacaoDinamicaPerformance() {
        testarPerformance(programacaoDinamica, TAMANHO_MAXIMO_PROGRAMACAO_DINAMICA);
    }

    private void testarPerformance(Object solver, int tamanhoMaximo) {
        int tamanhoAtual = TAMANHO_INICIAL;
        if (solver instanceof LeilaoSolverProgramacaoDinamica || solver instanceof LeilaoSolverGreedyUnitario || solver instanceof LeilaoSolverGreedyValorDesc) {
            tamanhoAtual = TAMANHO_MAXIMO_BACKTRACK;
        }

        boolean limiteAlcancado = false;
        List<ResultadoDTO> resultados = new ArrayList<>();
        List<List<ResultadoDTO>> resultadoFinalTestes = new ArrayList<>();

        while (!limiteAlcancado && tamanhoAtual <= tamanhoMaximo) {
            List<Double> temposExecucao = new ArrayList<>();

            for (int i = 0; i < 10; i++) {
                limparEmpresasInteressadas();
                adicionarEmpresasInteressadas(tamanhoAtual);

                ResultadoDTO resultado = executarTeste(solver, 3L);
                long duracaoSegundos = TimeUnit.NANOSECONDS.toSeconds(resultado.getDuracao());
                temposExecucao.add((double) duracaoSegundos);
                resultados.add(resultado);
                System.out.println("Execução " + (i + 1) + " com tamanho " + tamanhoAtual + ": " + duracaoSegundos + " segundos");
            }

            double mediaDuracao = temposExecucao.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
            System.out.println("Tamanho: " + tamanhoAtual + " - Média de execução: " + mediaDuracao + " segundos");

            if (tamanhoAtual == TAMANHO_MAXIMO_BACKTRACK) {
                resultadoFinalTestes.add(resultados);
                System.out.println("\n\n\n\n IF INDIVIDUAL" + resultadoFinalTestes.getLast());
            }

            if (mediaDuracao > 30) { // Limite de tempo em segundos
                limiteAlcancado = true;
                System.out.println("Tempo limite estourado na média com tamanho: " + tamanhoAtual);
                break; // Sai do loop caso o limite de tempo seja alcançado
            }else{
                tamanhoAtual++;
                resultados.clear();
            }
        }

        // Imprimir resultados finais, se necessário
        for (ResultadoDTO resultado : resultados) {
            System.out.println("Resultado: " + resultado);
        }
    }

    private void limparEmpresasInteressadas() {
        empresaInteressadaRepository.deleteAll();
    }

    private void adicionarEmpresasInteressadas(int quantidade) {
        for (int i = 0; i < quantidade; i++) {
            empresaInteressadaRepository.save(empresas.get(i));
        }
    }

    private static List<EmpresaInteressada> gerarEmpresasInteressadas(int quantidade) {
        List<EmpresaInteressada> empresas = new ArrayList<>();
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
            empresas.add(empresaInteressada);
            System.out.print(empresaInteressada.getQuantRequerida() + " - ");
        }
        return empresas;
    }

    private ResultadoDTO executarTeste(Object solver, Long empresaId) {
        ResultadoDTO resultado = new ResultadoDTO();
        resultado.iniciarContagem();
        try {
            if (solver instanceof LeilaoSolverBacktrack) {
                resultado = ((LeilaoSolverBacktrack) solver).resolverLeilao(empresaId);
            } else if (solver instanceof LeilaoSolverDivisaoEConquista) {
                resultado = ((LeilaoSolverDivisaoEConquista) solver).InicializaLeilao(empresaId);
            } else if (solver instanceof LeilaoSolverGreedyUnitario) {
                resultado = ((LeilaoSolverGreedyUnitario) solver).resolverLeilaoGreedyUnitario(empresaId);
            } else if (solver instanceof LeilaoSolverGreedyValorDesc) {
                resultado = ((LeilaoSolverGreedyValorDesc) solver).resolverLeilaoSolverGreedyValorDescI(empresaId);
            } else if (solver instanceof LeilaoSolverProgramacaoDinamica) {
                resultado = ((LeilaoSolverProgramacaoDinamica) solver).resolverLeilaoProgramacaoDinamica(empresaId);
            } else {
                throw new IllegalArgumentException("Solver não suportado: " + solver.getClass().getName());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            resultado.finalizarContagem();
        }

        return resultado;
    }
}
