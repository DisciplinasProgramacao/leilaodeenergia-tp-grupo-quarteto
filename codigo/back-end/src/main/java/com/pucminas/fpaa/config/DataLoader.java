package com.pucminas.fpaa.config;

import com.pucminas.fpaa.entity.EmpresaInteressada;
import com.pucminas.fpaa.entity.EmpresaVendedora;
import com.pucminas.fpaa.repositories.EmpresaInteressadaRepository;
import com.pucminas.fpaa.repositories.EmpresaVendedoraRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final EmpresaVendedoraRepository empresaVendedoraRepository;

    private final EmpresaInteressadaRepository empresaInteressadaRepository;

    @Override
    public void run(String... args) throws Exception {
        loadInitialData();
    }

    private void loadInitialData() {
        try {
            // Lê o arquivo de input
            ClassPathResource resource = new ClassPathResource("static/input.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));

            // Cria empresas vendedoras
            EmpresaVendedora qualinergico = EmpresaVendedora.builder()
                    .nome("Qualinergico")
                    .quant_disponivel(8000)
                    .quant_vendida(0)
                    .build();
            empresaVendedoraRepository.save(qualinergico);

            EmpresaVendedora limpagia = EmpresaVendedora.builder()
                    .nome("Limpagia")
                    .quant_disponivel(8000)
                    .quant_vendida(0)
                    .build();
            empresaVendedoraRepository.save(limpagia);

            // Define uma lista para armazenar empresas interessadas temporariamente
            List<EmpresaInteressada> interessadas = new ArrayList<>();

            // Define a empresa vendedora atual
            EmpresaVendedora currentVendedora = qualinergico;

            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();

                // Muda a empresa vendedora quando encontra o marcador do segundo conjunto
                if (line.startsWith("* Conjunto de empresas interessadas 2")) {
                    currentVendedora = limpagia;
                    continue;
                }

                // Ignora linhas que não contêm dados relevantes
                if (line.isEmpty() || line.startsWith("*") || line.startsWith("(")) {
                    continue;
                }

                // Processa a linha com dados da empresa interessada
                String[] parts = line.split(";");
                if (parts.length == 3) {
                    String nome = parts[0];
                    int quantRequerida = Integer.parseInt(parts[1]);
                    double valor = Double.parseDouble(parts[2]);

                    EmpresaInteressada interessada = EmpresaInteressada.builder()
                            .nome(nome)
                            .quantRequerida(quantRequerida)
                            .valor(valor)
                            .empresaVendedora(currentVendedora)
                            .build();
                    interessadas.add(interessada);
                }
            }

            // Salva todas as empresas interessadas
            empresaInteressadaRepository.saveAll(interessadas);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
