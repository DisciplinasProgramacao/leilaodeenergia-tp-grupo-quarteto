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
import java.util.Comparator;
import java.util.List;
@Service
public class LeilaoSolverDivisaoEConquista implements LeilaoSolverDivisaoEConquistaI {
    private final EmpresaVendedoraRepository _empresaVendedoraRepository;
    private final EmpresaInteressadaRepository _empresaInteressadaRepository;
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
            resultadoDTO.setMelhorSelecao(resolverLeilaoDivisaoEConquista(empresasInteressadas, empresaVendedora.getQuant_disponivel() - empresaVendedora.getQuant_vendida()));
            resultadoDTO.setAlgoritmoUtilizado(AlgoritmoEnum.DIVISAOECONQUISTA);
            resultadoDTO.setQuantidadeVendida(resultadoDTO.getMelhorSelecao().stream().mapToInt(EmpresaInteressada::getQuantRequerida).sum());
            resultadoDTO.setMelhorLucro(resultadoDTO.getMelhorSelecao().stream().mapToDouble(EmpresaInteressada::getValor).sum());
            resultadoDTO.finalizarContagem();
        }else{
            throw new Exception("Resultado não encontrado");
        }
        return resultadoDTO;
    }

    private List<EmpresaInteressada> resolverLeilaoDivisaoEConquista(List<EmpresaInteressada> empresasInteressadas, int quantidadeEnergiaDisponivel){
        List<EmpresaInteressada> empresasSelecionadas = new ArrayList<>();
        int valorInicial = empresasInteressadas.stream().min(Comparator.comparing(EmpresaInteressada::getQuantRequerida)).orElse(null).getQuantRequerida();
        if(quantidadeEnergiaDisponivel/2 <= valorInicial){
            EmpresaInteressada empresaSelecionada =  empresasInteressadas.stream().filter(e -> e.getQuantRequerida() <= quantidadeEnergiaDisponivel)
                    .max(Comparator.comparing(EmpresaInteressada::getValor)).orElse(null);
            if(empresaSelecionada != null){
                empresasInteressadas.remove(empresaSelecionada);
                empresasSelecionadas.add(empresaSelecionada);
            }
            return empresasSelecionadas;
        }
            List<EmpresaInteressada> direita = resolverLeilaoDivisaoEConquista(empresasInteressadas, quantidadeEnergiaDisponivel/2);
            List<EmpresaInteressada> esquerda = resolverLeilaoDivisaoEConquista(empresasInteressadas, quantidadeEnergiaDisponivel/2);
        return compararListas(empresasInteressadas, direita, esquerda, quantidadeEnergiaDisponivel);
    }

    private List<EmpresaInteressada> compararListas(List<EmpresaInteressada> empresasInteressadas, List<EmpresaInteressada> direita, List<EmpresaInteressada> esquerda, int quantidadeEnergiaDisponivel) {
        List<EmpresaInteressada> empresasSelecionadas = new ArrayList<>(direita);
        empresasSelecionadas.addAll(esquerda);
        int valorTotalInserido = (int)empresasSelecionadas.stream().mapToDouble(EmpresaInteressada::getValor).sum();
        int quantidadeTotalInserido = (int)empresasSelecionadas.stream().mapToDouble(EmpresaInteressada::getQuantRequerida).sum();
        if(quantidadeEnergiaDisponivel - empresasSelecionadas.stream().mapToInt(EmpresaInteressada::getQuantRequerida).sum() > 0){
            //Adiciona Empresa caso tenha energia disponivel
            EmpresaInteressada empresaSelecionada =  empresasInteressadas.stream()
                    .filter(e -> e.getQuantRequerida() <= quantidadeEnergiaDisponivel- quantidadeTotalInserido).max(Comparator.comparing(EmpresaInteressada::getValor)).orElse(null);
            if(empresaSelecionada != null){
                empresasInteressadas.remove(empresaSelecionada);
                empresasSelecionadas.add(empresaSelecionada);
                valorTotalInserido = (int)empresasSelecionadas.stream().mapToDouble(EmpresaInteressada::getValor).sum();
            }
        }
        int finalValorTotal = valorTotalInserido;
        EmpresaInteressada empresaSelecionadaTroca =  empresasInteressadas.stream()
                .filter(e -> e.getQuantRequerida() <= quantidadeEnergiaDisponivel && e.getValor() > finalValorTotal).findFirst().orElse(null);
        if(empresaSelecionadaTroca != null){
            empresasInteressadas.addAll(empresasSelecionadas);
            empresasInteressadas.remove(empresaSelecionadaTroca);
            empresasSelecionadas.clear();
            empresasSelecionadas.add(empresaSelecionadaTroca);
        }
        return empresasSelecionadas;
    }
}
