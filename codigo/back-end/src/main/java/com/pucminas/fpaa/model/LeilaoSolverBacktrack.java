package com.pucminas.fpaa.model;

import com.pucminas.fpaa.dtos.ResultadoDTO;
import com.pucminas.fpaa.entity.EmpresaInteressada;
import com.pucminas.fpaa.entity.EmpresaVendedora;
import com.pucminas.fpaa.enums.AlgoritmoEnum;
import com.pucminas.fpaa.repositories.EmpresaInteressadaRepository;
import com.pucminas.fpaa.repositories.EmpresaVendedoraRepository;
import com.pucminas.fpaa.interfaces.LeilaoSolverBacktrackI;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

@Service
public class LeilaoSolverBacktrack implements LeilaoSolverBacktrackI {

    private final EmpresaVendedoraRepository empresaVendedoraRepository;
    private final EmpresaInteressadaRepository empresaInteressadaRepository;
    private double melhorLucro;
    private List<EmpresaInteressada> melhorSelecao;

    private void init() {
        this.melhorLucro = 0;
        this.melhorSelecao = new ArrayList<>();
    }

    public LeilaoSolverBacktrack(EmpresaVendedoraRepository empresaVendedoraRepository, EmpresaInteressadaRepository empresaInteressadaRepository) {
        this.empresaVendedoraRepository = empresaVendedoraRepository;
        this.empresaInteressadaRepository = empresaInteressadaRepository;
        init();
    }

    @Override
    public ResultadoDTO resolverLeilao(Long idEmpresa) {
        init();
        ResultadoDTO resultadoDTO = new ResultadoDTO();
        EmpresaVendedora empresaVendedora = empresaVendedoraRepository.findById(idEmpresa).orElse(null);

        if (empresaVendedora != null) {
            List<EmpresaInteressada> empresasInteressadas = empresaInteressadaRepository.findByEmpresaVendedoraId(idEmpresa);

            List<EmpresaInteressada> selecaoAtual = new ArrayList<>();
            double lucroAtual = 0;
            int quantidadeDisponivel = empresaVendedora.getQuant_disponivel() - empresaVendedora.getQuant_vendida();

            resultadoDTO.iniciarContagem();

            empresasInteressadas.sort(Comparator.comparingDouble(e -> -e.getValor() / e.getQuantRequerida()));
            backtrack(0, quantidadeDisponivel, empresasInteressadas, selecaoAtual, lucroAtual);

            resultadoDTO.finalizarContagem();
            resultadoDTO.setMelhorSelecao(melhorSelecao);
            resultadoDTO.setMelhorLucro(melhorLucro);
            resultadoDTO.setQuantidadeVendida(melhorSelecao.stream().mapToInt(EmpresaInteressada::getQuantRequerida).sum());
            resultadoDTO.setAlgoritmoUtilizado(AlgoritmoEnum.BACKTRAKING);

        }

        return resultadoDTO;
    }

    private void backtrack(int indice, int quantidadeDisponivel, List<EmpresaInteressada> empresasInteressadas, List<EmpresaInteressada> selecaoAtual, double lucroAtual) {
        if (indice == empresasInteressadas.size()) {
            if (lucroAtual > melhorLucro) {
                melhorLucro = lucroAtual;
                melhorSelecao = new ArrayList<>(selecaoAtual);
            }
            return;
        }

        EmpresaInteressada empresa = empresasInteressadas.get(indice);

        if (empresa != null && empresa.getQuantRequerida() <= quantidadeDisponivel) {
            selecaoAtual.add(empresa);
            backtrack(indice + 1, quantidadeDisponivel - empresa.getQuantRequerida(), empresasInteressadas, selecaoAtual, lucroAtual + empresa.getValor());
            selecaoAtual.remove(selecaoAtual.size() - 1);
        }

        backtrack(indice + 1, quantidadeDisponivel, empresasInteressadas, selecaoAtual, lucroAtual);
    }

}