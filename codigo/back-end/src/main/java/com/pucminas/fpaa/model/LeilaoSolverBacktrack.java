/*
package com.pucminas.fpaa.model;

import com.pucminas.fpaa.dtos.ResultadoDTO;
import com.pucminas.fpaa.entity.EmpresaInteressada;
import com.pucminas.fpaa.entity.EmpresaVendedora;
import com.pucminas.fpaa.enums.AlgoritmoEnum;
import com.pucminas.fpaa.repositories.EmpresaInteressadaRepository;
import com.pucminas.fpaa.repositories.EmpresaVendedoraRepository;
import com.pucminas.fpaa.repositories.LoteEnergiaRepository;
import com.pucminas.fpaa.ìnterfaces.LeilaoSolverBacktrackI;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class LeilaoSolverBacktrack implements LeilaoSolverBacktrackI {

    private final LoteEnergiaRepository loteEnergiaRepository;
    private final EmpresaVendedoraRepository empresaVendedoraRepository;

    private final EmpresaInteressadaRepository empresaInteressadaRepository;
    private double melhorLucro;
    private List<EmpresaInteressada> melhorSelecao;

    public LeilaoSolverBacktrack(LoteEnergiaRepository loteEnergiaRepository, EmpresaVendedoraRepository empresaVendedoraRepository, EmpresaInteressadaRepository empresaInteressadaRepository) {
        this.loteEnergiaRepository = loteEnergiaRepository;
        this.empresaVendedoraRepository = empresaVendedoraRepository;
        this.empresaInteressadaRepository = empresaInteressadaRepository;
        this.melhorLucro = 0;
        this.melhorSelecao = new ArrayList<>();
    }

    @Override
    public ResultadoDTO resolverLeilao(Long idEmpresa) {
        ResultadoDTO resultadoDTO = new ResultadoDTO();
        EmpresaVendedora empresaVendedora = empresaVendedoraRepository.findById(idEmpresa).orElse(null);

        if (empresaVendedora != null) {
            List<LoteEnergia> lotesDisponiveis = empresaVendedora.getLotes().stream()
                    .filter(lote -> lote.getEmpresaCompradora() == null)
                    .toList();

            List<EmpresaInteressada> empresasInteressadas = new ArrayList<>();

            empresasInteressadas.addAll(empresaInteressadaRepository.findAllByLoteInteressadoEmpresaCompradoraIsNullAndEmpresaVendedoraId(idEmpresa));

            List<EmpresaInteressada> selecaoAtual = new ArrayList<>();
            double lucroAtual = 0;

            resultadoDTO.iniciarContagem();
                backtrack(0, lotesDisponiveis, empresasInteressadas, selecaoAtual, lucroAtual);
                resultadoDTO.setMelhorSelecao(melhorSelecao);
                resultadoDTO.setMelhorLucro(melhorLucro);
                resultadoDTO.setAlgoritmoUtilizado(AlgoritmoEnum.BACKTRAKING);
            resultadoDTO.finalizarContagem();

            definirCompradores(lotesDisponiveis);
        }

        return resultadoDTO;
    }

    private void definirCompradores(List<LoteEnergia> lotesDisponiveis) {
        for (LoteEnergia lote : lotesDisponiveis) {
            melhorSelecao.stream()
                    .filter(empresa -> empresa.getLoteInteressado().getId().equals(lote.getId()))
                    .findFirst()
                    .ifPresent(lote::setEmpresaCompradora);
        }
    }

    private void backtrack(int indice, List<LoteEnergia> lotesDisponiveis, List<EmpresaInteressada> empresasInteressadas, List<EmpresaInteressada> selecaoAtual, double lucroAtual) {
        if (indice == empresasInteressadas.size()) {
            if (lucroAtual > melhorLucro) {
                melhorLucro = lucroAtual;
                melhorSelecao = new ArrayList<>(selecaoAtual);
            }
            return;
        }

        EmpresaInteressada empresa = empresasInteressadas.get(indice);

        if (empresa != null) {
            //verifica se o lote interessado esta disponivel e se ele ja não foi selacionado posteriormente
            if (lotesDisponiveis.contains(empresa.getLoteInteressado()) && !loteJaSelecionado(selecaoAtual, empresa.getLoteInteressado())) {
                selecaoAtual.add(empresa);
                backtrack(indice + 1, lotesDisponiveis, empresasInteressadas, selecaoAtual, lucroAtual + empresa.getLance());
                selecaoAtual.remove(selecaoAtual.size() - 1);

            }
        }
        backtrack(indice + 1, lotesDisponiveis, empresasInteressadas, selecaoAtual, lucroAtual);
    }
    private boolean loteJaSelecionado(List<EmpresaInteressada> selecaoAtual, LoteEnergia lote) {
        for (EmpresaInteressada empresa : selecaoAtual) {
            if (empresa.getLoteInteressado().getId().equals(lote.getId())) {
                return true;
            }
        }
        return false;
    }
}
*/
