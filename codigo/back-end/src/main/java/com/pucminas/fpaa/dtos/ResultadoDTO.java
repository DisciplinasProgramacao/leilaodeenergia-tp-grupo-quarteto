package com.pucminas.fpaa.dtos;

import com.pucminas.fpaa.entity.EmpresaInteressada;
import com.pucminas.fpaa.enums.AlgoritmoEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ResultadoDTO {
    private long duracao;
    private boolean isRunning;
    private long startTime;
    private AlgoritmoEnum algoritmoUtilizado;
    private double melhorLucro;
    private List<EmpresaInteressada> melhorSelecao;
    private int quantidadeVendida;

    public ResultadoDTO() {
        this.duracao = 0;
        this.isRunning = false;
        this.startTime = 0;
        this.algoritmoUtilizado = null;
        this.melhorLucro = 0.0;
        this.melhorSelecao = new ArrayList<>();
        this.quantidadeVendida = 0;
    }

    public void iniciarContagem() {
        if (!isRunning) {
            startTime = System.nanoTime();
            isRunning = true;
        }
    }

    // Método para finalizar a contagem de tempo e calcular a duração
    public void finalizarContagem() {
        if (isRunning) {
            long endTime = System.nanoTime();
            duracao += endTime - startTime;
            isRunning = false;
        }
    }

    // Método para resetar a contagem de tempo
    public void resetarContagem() {
        duracao = 0;
        isRunning = false;
    }

    public String getDuracaoFormatadaMillis() {
        return String.format("%d ms", TimeUnit.NANOSECONDS.toMillis(duracao));
    }

    // Método para obter a duração formatada em segundos
    public String getDuracaoFormatadaSegundos() {
        return String.format("%d s", TimeUnit.NANOSECONDS.toSeconds(duracao));
    }

    public long getDuracao() {
        return duracao;
    }

    public void setDuracao(long duracao) {
        this.duracao = duracao;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public AlgoritmoEnum getAlgoritmoUtilizado() {
        return algoritmoUtilizado;
    }

    public void setAlgoritmoUtilizado(AlgoritmoEnum algoritmoUtilizado) {
        this.algoritmoUtilizado = algoritmoUtilizado;
    }

    public double getMelhorLucro() {
        return melhorLucro;
    }

    public void setMelhorLucro(double melhorLucro) {
        this.melhorLucro = melhorLucro;
    }

    public List<EmpresaInteressada> getMelhorSelecao() {
        return melhorSelecao;
    }

    public void setMelhorSelecao(List<EmpresaInteressada> melhorSelecao) {
        this.melhorSelecao = melhorSelecao;
    }

    public int getQuantidadeVendida() {
        return quantidadeVendida;
    }

    public void setQuantidadeVendida(int quantidadeVendida) {
        this.quantidadeVendida = quantidadeVendida;
    }

}