package com.pucminas.fpaa.model;

import com.pucminas.fpaa.dtos.ResultadoDTO;
import com.pucminas.fpaa.entity.EmpresaInteressada;
import com.pucminas.fpaa.entity.EmpresaVendedora;
import com.pucminas.fpaa.entity.LoteEnergia;
import com.pucminas.fpaa.enums.AlgoritmoEnum;
import com.pucminas.fpaa.repositories.EmpresaInteressadaRepository;
import com.pucminas.fpaa.repositories.EmpresaVendedoraRepository;
import com.pucminas.fpaa.repositories.LoteEnergiaRepository;
import com.pucminas.fpaa.ìnterfaces.LeilaoSolverGreedyI;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class LeilaoSolverGreedy implements LeilaoSolverGreedyI {

    private final LoteEnergiaRepository loteEnergiaRepository;
    private final EmpresaVendedoraRepository empresaVendedoraRepository;
    private final EmpresaInteressadaRepository empresaInteressadaRepository;

    public LeilaoSolverGreedy(LoteEnergiaRepository loteEnergiaRepository, EmpresaVendedoraRepository empresaVendedoraRepository, EmpresaInteressadaRepository empresaInteressadaRepository) {
        this.loteEnergiaRepository = loteEnergiaRepository;
        this.empresaVendedoraRepository = empresaVendedoraRepository;
        this.empresaInteressadaRepository = empresaInteressadaRepository;
    }

    @Override
    public ResultadoDTO resolverLeilaoGreedy(Long idEmpresa) {
        ResultadoDTO resultadoDTO = new ResultadoDTO();
        EmpresaVendedora empresaVendedora = empresaVendedoraRepository.findById(idEmpresa).orElse(null);

        if (empresaVendedora != null) {
            List<LoteEnergia> lotesDisponiveis = empresaVendedora.getLotes().stream()
                    .filter(lote -> lote.getEmpresaCompradora() == null)
                    .toList();

            List<EmpresaInteressada> empresasInteressadas = new ArrayList<>();
            empresasInteressadas.addAll(empresaInteressadaRepository.findAllByLoteInteressadoEmpresaCompradoraIsNullAndEmpresaVendedoraId(idEmpresa));

            empresasInteressadas.sort(Comparator.comparingDouble(EmpresaInteressada::getLance).reversed());

            double lucroTotal = 0;
            List<EmpresaInteressada> melhorSelecao = new ArrayList<>();

            List<LoteEnergia> lotesDisponiveisMutable = new ArrayList<>(lotesDisponiveis);
            for (EmpresaInteressada empresa : empresasInteressadas) {
                if (lotesDisponiveisMutable.contains(empresa.getLoteInteressado())) {
                    lucroTotal += empresa.getLance();
                    melhorSelecao.add(empresa);
                    lotesDisponiveisMutable.remove(empresa.getLoteInteressado());
                }
            }

            resultadoDTO.setMelhorSelecao(melhorSelecao);
            resultadoDTO.setMelhorLucro(lucroTotal);
            resultadoDTO.setAlgoritmoUtilizado(AlgoritmoEnum.GREEDY);
        }

        return resultadoDTO;
    }
}
