### Análise Técnica do Algoritmo de Backtracking no Leilão

O algoritmo implementado em `LeilaoSolverBacktrack` usa a técnica de backtracking para resolver o problema de alocação de recursos de uma empresa vendedora para empresas interessadas. Vamos analisar detalhadamente cada parte do código, especialmente focando no critério de poda utilizado, a ordenação dos dados e outras decisões importantes.

#### Estrutura e Inicialização

A classe `LeilaoSolverBacktrack` implementa a interface `LeilaoSolverBacktrackI` e depende de dois repositórios: `EmpresaVendedoraRepository` e `EmpresaInteressadaRepository`. Estes são utilizados para buscar dados das empresas vendedoras e interessadas no banco de dados.

- **Atributos**:
    - `melhorLucro`: Armazena o melhor lucro encontrado durante a execução do algoritmo.
    - `melhorSelecao`: Armazena a melhor seleção de empresas interessadas que resultou no melhor lucro.

- **Método `init`**:
    - Inicializa `melhorLucro` com 0 e `melhorSelecao` com uma lista vazia.

#### Resolução do Leilão

- **Método `resolverLeilao`**:
    - Inicializa as variáveis com o método `init`.
    - Busca a `EmpresaVendedora` pelo seu ID.
    - Busca as `EmpresasInteressadas` associadas a esta vendedora.
    - Ordena as empresas interessadas com base no valor por unidade de recurso requerido em ordem decrescente.

#### Ordenação dos Dados

A ordenação das empresas interessadas é realizada com base na razão `valor / quantidade requerida`. Isso é feito usando um `Comparator`:
```java
empresasInteressadas.sort(Comparator.comparingDouble(e -> -e.getValor() / e.getQuantRequerida()));
```
Essa ordenação prioriza as empresas que oferecem mais valor por unidade de recurso, maximizando a eficiência da alocação de recursos.

#### Função de Backtracking

O método `backtrack` é o núcleo do algoritmo. Ele tenta todas as combinações possíveis de empresas interessadas para encontrar aquela que maximiza o lucro sem exceder a quantidade disponível de recursos.

##### Estrutura da Função `backtrack`

- **Parâmetros**:
    - `indice`: Índice atual na lista de empresas interessadas.
    - `quantidadeDisponivel`: Quantidade de recursos ainda disponíveis.
    - `empresasInteressadas`: Lista de todas as empresas interessadas.
    - `selecaoAtual`: Lista atual de empresas interessadas selecionadas.
    - `lucroAtual`: Lucro acumulado com a seleção atual.

##### Critério de Poda

O algoritmo de backtracking implementado usa um **critério de poda por viabilidade**. Esse tipo de poda descarta caminhos no espaço de busca que violam as restrições do problema, neste caso, a restrição de quantidade disponível de recursos.

#### Explicação da Poda por Viabilidade

No contexto deste algoritmo, a poda por viabilidade ocorre quando verificamos se a quantidade requerida por uma empresa interessada não excede a quantidade disponível de recursos. Se a quantidade requerida for maior que a quantidade disponível, o caminho atual é considerado inviável e é podado, ou seja, a recursão não continua explorando esse caminho.

#### Detalhes Específicos no Código

A poda por viabilidade é implementada na seguinte parte do código:

```java
if (empresa != null && empresa.getQuantRequerida() <= quantidadeDisponivel) {
    selecaoAtual.add(empresa);
    backtrack(indice + 1, quantidadeDisponivel - empresa.getQuantRequerida(), empresasInteressadas, selecaoAtual, lucroAtual + empresa.getValor());
    selecaoAtual.remove(selecaoAtual.size() - 1);
}
```

Vamos analisar em detalhes:

1. **Condição de Viabilidade**:
    ```java
    if (empresa != null && empresa.getQuantRequerida() <= quantidadeDisponivel)
    ```
    - `empresa != null`: Verifica se a empresa atual não é nula.
    - `empresa.getQuantRequerida() <= quantidadeDisponivel`: Verifica se a quantidade requerida pela empresa não excede a quantidade disponível de recursos. Se esta condição for falsa, o caminho atual é podado.

2. **Ação se Viável**:
    - Se a condição for verdadeira, a empresa é adicionada à seleção atual (`selecaoAtual.add(empresa)`).
    - A recursão continua com a quantidade disponível de recursos reduzida pela quantidade requerida pela empresa (`backtrack(indice + 1, quantidadeDisponivel - empresa.getQuantRequerida(), empresasInteressadas, selecaoAtual, lucroAtual + empresa.getValor())`).
    - Após a chamada recursiva, a empresa é removida da seleção atual para explorar outros caminhos possíveis (`selecaoAtual.remove(selecaoAtual.size() - 1)`).

#### Resultado

O método `resolverLeilao` retorna um objeto `ResultadoDTO` que contém:
- A melhor seleção de empresas interessadas (`melhorSelecao`).
- O melhor lucro encontrado (`melhorLucro`).
- A quantidade total de recursos vendidos (`quantidadeVendida`).
- O algoritmo utilizado (`AlgoritmoEnum.BACKTRAKING`).

