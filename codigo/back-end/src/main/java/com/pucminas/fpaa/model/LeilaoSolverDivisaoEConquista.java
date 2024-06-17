package com.pucminas.fpaa.model;

import com.pucminas.fpaa.dtos.ResultadoDTO;
import com.pucminas.fpaa.entity.EmpresaInteressada;
import com.pucminas.fpaa.entity.EmpresaVendedora;
import com.pucminas.fpaa.enums.AlgoritmoEnum;
import com.pucminas.fpaa.repositories.EmpresaInteressadaRepository;
import com.pucminas.fpaa.repositories.EmpresaVendedoraRepository;
import com.pucminas.fpaa.interfaces.LeilaoSolverDivisaoEConquistaI;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class LeilaoSolverDivisaoEConquista implements LeilaoSolverDivisaoEConquistaI {
    private final EmpresaVendedoraRepository _empresaVendedoraRepository;
    private final EmpresaInteressadaRepository _empresaInteressadaRepository;
    private List<EmpresaInteressada> empresasSelecionadas = new ArrayList<>();

    public LeilaoSolverDivisaoEConquista(EmpresaVendedoraRepository _empresaVendedoraRepository, EmpresaInteressadaRepository _empresaInteressadaRepository, List<EmpresaInteressada> empresasSelecionadas) {
        this._empresaVendedoraRepository = _empresaVendedoraRepository;
        this._empresaInteressadaRepository = _empresaInteressadaRepository;
    }

    public ResultadoDTO InicializaLeilao(Long idEmpresa) throws Exception {
        ResultadoDTO resultadoDTO = new ResultadoDTO();
        EmpresaVendedora empresaVendedora = _empresaVendedoraRepository.findById(idEmpresa).orElse(null);
        if (empresaVendedora != null) {
            resultadoDTO.iniciarContagem();
            List<EmpresaInteressada> empresasInteressadas = _empresaInteressadaRepository.findByEmpresaVendedoraId(idEmpresa);
            resultadoDTO.setMelhorSelecao(resolverLeilaoDivisaoEConquista(empresasInteressadas, empresaVendedora.getQuant_disponivel() - empresaVendedora.getQuant_vendida(), empresasInteressadas.size() - 1));
            resultadoDTO.setAlgoritmoUtilizado(AlgoritmoEnum.DIVISAOECONQUISTA);
            resultadoDTO.setQuantidadeVendida(resultadoDTO.getMelhorSelecao().stream().mapToInt(EmpresaInteressada::getQuantRequerida).sum());
            resultadoDTO.setMelhorLucro(resultadoDTO.getMelhorSelecao().stream().mapToDouble(EmpresaInteressada::getValor).sum());
            resultadoDTO.finalizarContagem();
        }else{
            throw new Exception("Resultado não encontrado");
        }
        return resultadoDTO;
    }
    private  List<EmpresaInteressada> resolverLeilaoDivisaoEConquista(List<EmpresaInteressada> empresas, int energiaDisponivel, int index) {
        if (index < 0 || energiaDisponivel <= 0) {
            return new ArrayList<>();
        }
        if (empresas.get(index).getQuantRequerida() > energiaDisponivel) {
            return resolverLeilaoDivisaoEConquista(empresas, energiaDisponivel, index - 1);
        } else {
            List<EmpresaInteressada> incluirEmpresa = new ArrayList<>();
            incluirEmpresa.addAll(resolverLeilaoDivisaoEConquista(empresas, energiaDisponivel - empresas.get(index).getQuantRequerida(), index - 1));
            incluirEmpresa.add(empresas.get(index));

            List<EmpresaInteressada> naoIncluirEmpresa = resolverLeilaoDivisaoEConquista(empresas, energiaDisponivel, index - 1);
            double valorIncluir = incluirEmpresa.stream().mapToDouble(EmpresaInteressada::getValor).sum();
            double valorNaoIncluir = naoIncluirEmpresa.stream().mapToDouble(EmpresaInteressada::getValor).sum();

            if (valorIncluir > valorNaoIncluir) {
                return incluirEmpresa;
            } else {
                return naoIncluirEmpresa;
            }
        }
    }
}
