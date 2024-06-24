package com.pucminas.fpaa.model;

import com.pucminas.fpaa.dtos.ResultadoDTO;
import com.pucminas.fpaa.entity.EmpresaInteressada;
import com.pucminas.fpaa.entity.EmpresaVendedora;
import com.pucminas.fpaa.enums.AlgoritmoEnum;
import com.pucminas.fpaa.interfaces.LeilaoSolverGreedyValorDescI;
import com.pucminas.fpaa.repositories.EmpresaInteressadaRepository;
import com.pucminas.fpaa.repositories.EmpresaVendedoraRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class LeilaoSolverGreedyValorDesc implements LeilaoSolverGreedyValorDescI {

    private final EmpresaVendedoraRepository empresaVendedoraRepository;
    private final EmpresaInteressadaRepository empresaInteressadaRepository;

    public LeilaoSolverGreedyValorDesc(EmpresaVendedoraRepository empresaVendedoraRepository, EmpresaInteressadaRepository empresaInteressadaRepository) {
        this.empresaVendedoraRepository = empresaVendedoraRepository;
        this.empresaInteressadaRepository = empresaInteressadaRepository;
    }

    @Override
    public ResultadoDTO resolverLeilaoSolverGreedyValorDescI(Long idEmpresa) {
        ResultadoDTO resultadoDTO = new ResultadoDTO();
        EmpresaVendedora empresaVendedora = empresaVendedoraRepository.findById(idEmpresa).orElse(null);

        if (empresaVendedora != null) {
            List<EmpresaInteressada> empresasInteressadas = empresaInteressadaRepository.findByEmpresaVendedoraId(idEmpresa);

            int quantidadeDisponivel = empresaVendedora.getQuant_disponivel() - empresaVendedora.getQuant_vendida();
            double melhorLucro = 0;
            List<EmpresaInteressada> melhorSelecao = new ArrayList<>();

            resultadoDTO.iniciarContagem();

            empresasInteressadas.sort(Comparator.comparingDouble(e -> -e.getValor()));

            for (EmpresaInteressada empresa : empresasInteressadas) {
                if (empresa.getQuantRequerida() <= quantidadeDisponivel) {
                    melhorSelecao.add(empresa);
                    melhorLucro += empresa.getValor();
                    quantidadeDisponivel -= empresa.getQuantRequerida();
                }
            }

            resultadoDTO.finalizarContagem();
            resultadoDTO.setMelhorSelecao(melhorSelecao);
            resultadoDTO.setMelhorLucro(melhorLucro);
            resultadoDTO.setQuantidadeVendida(melhorSelecao.stream().mapToInt(EmpresaInteressada::getQuantRequerida).sum());
            resultadoDTO.setAlgoritmoUtilizado(AlgoritmoEnum.GREEDY1);
        }

        return resultadoDTO;
    }
}
