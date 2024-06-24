### Análise Técnica do Algoritmo de Programação Dinâmica no Leilão

O algoritmo implementado em `LeilaoSolverProgramacaoDinamica` usa a técnica de programação dinâmica para resolver o problema de alocação de recursos de uma empresa vendedora para empresas interessadas. Vamos analisar detalhadamente cada parte do código, especialmente focando nos critérios utilizados, a ordenação dos dados e outras decisões importantes.

#### Estrutura e Inicialização

A classe `LeilaoSolverProgramacaoDinamica` implementa a interface `LeilaoSolverProgramacaoDinamicaI` e depende de dois repositórios: `EmpresaVendedoraRepository` e `EmpresaInteressadaRepository`. Estes são utilizados para buscar dados das empresas vendedoras e interessadas no banco de dados.

#### Resolução do Leilão

- **Método `resolverLeilaoProgramacaoDinamica`**:
    - Inicializa as variáveis.
    - Busca a `EmpresaVendedora` pelo seu ID.
    - Busca as `EmpresasInteressadas` associadas a esta vendedora.

#### Função de resolverLeilaoProgramacaoDinamica

O método `resolverLeilaoProgramacaoDinamica` é o núcleo do algoritmo. Ele montra uma matriz com todas as combinações possíveis de empresas interessadas para encontrar aquela que maximiza o lucro sem exceder a quantidade disponível de recursos. A construção da tabela é feita através de dois laços aninhados que percorrem todas as empresas e todas as possíveis quantidades de recursos disponíveis. Se a quantidade requerida pela empresa é menor ou igual à quantidade de recursos disponível, temos duas opções, Não incluir a empresa no leilão e manter o valor máximo de lucro, ou Incluir a empresa no leilão e adicionar o valor do lucro ao valor máximo de lucro obtido com recursos restantes.

##### Estrutura da Função `resolverLeilaoProgramacaoDinamica`

- **Parâmetros**:
    - `idEmpresa`: ID da empresa vendedora.
    - `quantidadeDisponivel`: Quantidade de recursos ainda disponíveis.
    - `empresasInteressadas`: Lista de todas as empresas interessadas.

No contexto deste algoritmo, a programação dinâmica é usada para evitar recomputações e armazenar os resultados de subproblemas em uma tabela. Esta abordagem é eficiente para problemas de otimização como o de alocação de recursos em leilões. 

Vamos analisar em detalhes:
#### 1 **construindo a tabela**

```java
for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= quantidadeTotal; w++) {
                if (pesos[i - 1] <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - pesos[i - 1]] + valores[i - 1]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
```

#### Abordagem da Tabela
  - `Linha`: Empresas Interessadas.
  - `Coluna`: Valor total disponível incrementado de um a um.
  - `Célula`: Lucro encontrado.

2. **Recuperação da Solução Ótima**:
    Após construir a tabela de programação dinâmica, o próximo passo é recuperar as empresas que compõem a solução ótima.
```java
int w = quantidadeTotal;
List<EmpresaInteressada> interessadasSelecionadas = new ArrayList<>();
for (int i = n; i > 0 && w > 0; i--) {
    if (dp[i][w] != dp[i - 1][w]) {
        interessadasSelecionadas.add(interessadas.get(i - 1));
        w -= pesos[i - 1];
    }
}

```
    A iteração começa do fim da tabela dp e verifica se a empresa i foi incluída na solução ótima. Se dp[i][w] é diferente de dp[i - 1][w], isso indica que a empresa i-ésima foi incluída. Então a empresa é adicionada à lista `interessadasSelecionadas` e a quantidade de recursos w é diminuída pela quantidade requerida pela empresa.


#### Resultado

O método `resolverLeilao` retorna um objeto `ResultadoDTO` que contém:
- A melhor seleção de empresas interessadas (`melhorSelecao`).
- O melhor lucro encontrado (`melhorLucro`).
- A quantidade total de recursos vendidos (`quantidadeVendida`).
- O algoritmo utilizado (`AlgoritmoEnum.PROGRAMACAODINAMICA`).

