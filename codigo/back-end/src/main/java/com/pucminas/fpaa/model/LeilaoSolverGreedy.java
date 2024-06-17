package com.pucminas.fpaa.model;

import com.pucminas.fpaa.dtos.ResultadoDTO;
import com.pucminas.fpaa.entity.EmpresaInteressada;
import com.pucminas.fpaa.entity.EmpresaVendedora;
import com.pucminas.fpaa.enums.AlgoritmoEnum;
import com.pucminas.fpaa.repositories.EmpresaInteressadaRepository;
import com.pucminas.fpaa.repositories.EmpresaVendedoraRepository;
import com.pucminas.fpaa.interfaces.LeilaoSolverGreedyI;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class LeilaoSolverGreedy implements LeilaoSolverGreedyI {

    private final EmpresaVendedoraRepository empresaVendedoraRepository;
    private final EmpresaInteressadaRepository empresaInteressadaRepository;

    public LeilaoSolverGreedy(EmpresaVendedoraRepository empresaVendedoraRepository, EmpresaInteressadaRepository empresaInteressadaRepository) {
        this.empresaVendedoraRepository = empresaVendedoraRepository;
        this.empresaInteressadaRepository = empresaInteressadaRepository;
    }

    @Override
    public ResultadoDTO resolverLeilaoGreedy(Long idEmpresa) {
        ResultadoDTO resultadoDTO = new ResultadoDTO();
        EmpresaVendedora empresaVendedora = empresaVendedoraRepository.findById(idEmpresa).orElse(null);

        if (empresaVendedora != null) {
            List<EmpresaInteressada> empresasInteressadas = empresaInteressadaRepository.findByEmpresaVendedoraId(idEmpresa);


            empresasInteressadas.sort(Comparator.comparingDouble(EmpresaInteressada::getQuantRequerida).reversed());

            double lucroTotal = 0;
            List<EmpresaInteressada> melhorSelecao = new ArrayList<>();
            int quantidadeVendidaTotal = 0;
            resultadoDTO.iniciarContagem();
            for (EmpresaInteressada empresaInteressada : empresasInteressadas) {
                int quantRequerida = empresaInteressada.getQuantRequerida();
                double valorLance = empresaInteressada.getValor();

                if (quantRequerida > 0 && quantidadeVendidaTotal + quantRequerida < empresaVendedora.getQuant_disponivel()) {
                    melhorSelecao.add(empresaInteressada);
                    lucroTotal += valorLance;
                    quantidadeVendidaTotal += quantRequerida;
                }else{
                    for(EmpresaInteressada merlhores : melhorSelecao){
                        if(merlhores.getValor() < empresaInteressada.getValor() && merlhores.getQuantRequerida() >= empresaInteressada.getQuantRequerida()){
                            if(empresaInteressada.getQuantRequerida() + quantidadeVendidaTotal - merlhores.getQuantRequerida()< empresaVendedora.getQuant_disponivel()){}
                            melhorSelecao.remove(merlhores);
                            melhorSelecao.add(empresaInteressada);
                            lucroTotal -= merlhores.getValor();
                            quantidadeVendidaTotal -= merlhores.getQuantRequerida();
                            lucroTotal += valorLance;
                            quantidadeVendidaTotal += quantRequerida;
                            break;
                        }
                    }
                }
            }
            for (EmpresaInteressada melhores: melhorSelecao){
                melhores.setEmpresaVendedora(empresaVendedora);
            }
            resultadoDTO.finalizarContagem();
            resultadoDTO.setQuantidadeVendida(quantidadeVendidaTotal);
            //empresaVendedoraRepository.save(empresaVendedora);
            resultadoDTO.setMelhorSelecao(melhorSelecao);
            resultadoDTO.setMelhorLucro(lucroTotal);
            resultadoDTO.setAlgoritmoUtilizado(AlgoritmoEnum.GREEDY);

        }

        return resultadoDTO;
    }
}
