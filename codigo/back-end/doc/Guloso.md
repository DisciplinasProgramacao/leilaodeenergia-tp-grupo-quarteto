### Análise Técnica do Algoritmo Guloso no Leilão

O algoritmo implementado em `LeilaoSolverGreedyUnitario` e `LeilaoSolverGreedyValorDesc` os dois algoritimos utiliza a técnica Gulosa para resolver o problema de alocação de recursos de uma empresa vendedora para empresas interessadas. Vamos analisar detalhadamente cada parte do código, especialmente focando na lógica utilizada, a ordenação dos dados e outras decisões importantes.

#### Estrutura e Inicialização

A classe `LeilaoSolverGreedyUnitario` implementa a interface `LeilaoSolverGreedyUnitarioI` e depende de dois repositórios: `EmpresaVendedoraRepository` e `EmpresaInteressadaRepository`. Estes são utilizados para buscar dados das empresas vendedoras e interessadas no banco de dados.
e a classe `LeilaoSolverGreedyValorDesc` implementa a interface `LeilaoSolverGreedyValorDescI` e depende de dois repositórios: `EmpresaVendedoraRepository` e `EmpresaInteressadaRepository`. Estes são utilizados para buscar dados das empresas vendedoras e interessadas no banco de dados.

- **Atributos**:
    - `quantidadeDisponivel`: Armazena a quantidade disponivel pela empresa vendedora.
    - `melhorLucro`: Armazena o melhor lucro encontrado durante a execução do algoritmo.
    - `melhorSelecao`: Armazena a melhor seleção de empresas interessadas que resultou no melhor lucro.

#### Resolução do Leilão

- **Método `LeilaoSolverGreedyValorDesc` e `LeilaoSolverGreedyUnitario`**:
    - Busca a `EmpresaVendedora` pelo seu ID.
    - Busca as `EmpresasInteressadas` associadas a esta vendedora.
    - `LeilaoSolverGreedyUnitario` ordena as empresas interessadas com base no valor por unidade de recurso requerido em ordem decrescente.
    - `LeilaoSolverGreedyValorDesc` ordena as empresas interessadas com base no valor de forma decrescente.


#### Ordenação dos Dados

- **Método `LeilaoSolverGreedyUnitario`**:
A ordenação das empresas interessadas é realizada com base na razão `valor / quantidade requerida`. Isso é feito usando um `Comparator`:
```java
empresasInteressadas.sort(Comparator.comparingDouble(e -> -e.getValor() / e.getQuantRequerida()));
```
Essa ordenação prioriza as empresas que oferecem mais valor por unidade de recurso, maximizando a eficiência da alocação de recursos.

- **Método `LeilaoSolverGreedyValorDesc`**:
A ordenação das empresas interessadas é realizada com base no `valor` decrescente. Isso é feito usando um `Comparator`:
```java
empresasInteressadas.sort(Comparator.comparingDouble(e -> -e.getValor()));
```
Essa ordenação prioriza as empresas que oferecem os maiores valores maximizando o o lucro total.


#### Função do método Guloso 

O método `Guloso` Para resolver o problema de maximizar o lucro sem exceder a quantidade disponível de recursos usando o método guloso, seguimos uma abordagem onde fazemos escolhas locais ótimas na esperança de encontrar uma solução global ótima. No contexto deste problema, fizemos a escolhar de dois tipos diferentes de criterio isso pode ser traduzido em escolher as empresas com base em uma relação de "lucro por unidade de recurso" (custo-benefício) e pelo valor em forma decrescente adicionando até que os recursos se esgotem.

##### Estrutura da Função `Guloso`

- **Parâmetros**:
    - `quantidadeDisponivel`: Quantidade de recursos ainda disponíveis.
    - `empresasInteressadas`: Lista de todas as empresas interessadas.
    - `selecaoAtual`: Lista atual de empresas interessadas selecionadas.
    - `lucroAtual`: Lucro acumulado com a seleção atual.


#### Detalhes Específicos no Código `LeilaoSolverGreedyUnitario` e `LeilaoSolverGreedyValorDesc`

Vamos analisar em detalhes:

1. **Validação da Empresa Vendedora**:
    ```java
    if (empresaVendedora != null) {
    List<EmpresaInteressada> empresasInteressadas = empresaInteressadaRepository.findByEmpresaVendedoraId(idEmpresa);}
    ```
    Verifica se a empresa vendedora foi encontrada.
    Busca todas as empresas interessadas associadas à empresa vendedora.

    - `empresaVendedora != null`: Verifica se a empresa atual não é nula.
    - `List<EmpresaInteressada> empresasInteressadas`: Busca todas as empresas interessadas associadas à empresa vendedora.

2. **Inicialização de Variáveis**:

    ```java
    int quantidadeDisponivel = empresaVendedora.getQuant_disponivel() - empresaVendedora.getQuant_vendida();
    double melhorLucro = 0;
    List<EmpresaInteressada> melhorSelecao = new ArrayList<>();
    resultadoDTO.iniciarContagem();
    ```
    - `empresaVendedora.getQuant_disponivel() - empresaVendedora`: Calcula a quantidade disponível subtraindo a quantidade vendida da quantidade disponível.
    - Inicializa melhorLucro e melhorSelecao para armazenar os resultados do leilão..
    - Inicia a contagem de tempo no resultadoDTO.

3. **Iteração e Seleção Gulosa**:

    ```java
    for (EmpresaInteressada empresa : empresasInteressadas) {
    if (empresa.getQuantRequerida() <= quantidadeDisponivel) {
        melhorSelecao.add(empresa);
        melhorLucro += empresa.getValor();
        quantidadeDisponivel -= empresa.getQuantRequerida();
    }
    }
    ```
    - `EmpresaInteressada empresa : empresasInteressadas`: Itera sobre as empresas interessadas.
    - `empresa.getQuantRequerida() <= quantidadeDisponivel`: Seleciona as empresas cuja quantidade requerida é menor ou igual à quantidade disponível.
    - `melhorSelecao.add(empresa)`, `melhorLucro += empresa.getValor()`, `quantidadeDisponivel -= empresa.getQuantRequerida()`: Atualiza a melhorSelecao, melhorLucro e a quantidadeDisponivel.

#### Resultado

O método `resolverLeilao` retorna um objeto `ResultadoDTO` que contém:
- A melhor seleção de empresas interessadas (`melhorSelecao`).
- O melhor lucro encontrado (`melhorLucro`).
- A quantidade total de recursos vendidos (`quantidadeVendida`).
- O algoritmo utilizado (`AlgoritmoEnum.GREEDY e AlgoritmoEnum.GREEDY1`).