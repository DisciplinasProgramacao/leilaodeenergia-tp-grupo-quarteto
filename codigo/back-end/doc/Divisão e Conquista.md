### Análise Técnica do Algoritmo de Divisão e Conquista no Leilão


O algoritmo implementado em `LeilaoSolverBacktrack` usa a técnica de Divisão e conquista para resolver o problema de alocação de recursos de uma empresa vendedora para empresas interessadas. Vamos analisar detalhadamente cada parte do código, especialmente focando na lógica implementada e outras decisões importantes.


#### Estrutura e Inicialização

A classe `LeilaoSolverDivisaoEConquista` implementa a interface `LeilaoSolverDivisaoEConquistaI` e depende de dois repositórios: `EmpresaVendedoraRepository` e `EmpresaInteressadaRepository`. Estes são utilizados para buscar dados das empresas vendedoras e interessadas no banco de dados.


#### Resolução do Leilão


- **Método `InicializaLeilao`**:
    - Inicializa as variáveis com o método.
    - Busca a `EmpresaVendedora` pelo seu ID.
    - Busca as `EmpresasInteressadas` associadas a esta vendedora (pelo id da empresa vendedora).


#### Função de Duvisão e conquista


O método `resolverLeilaoDivisaoEConquista` é a base do algoritmo. Ele divide a quantidade de energia disponível até se aproximar da menor quantidade requerida pelas empresas interessadas ( Como podemos ver abaixo no: Condição de Parada). Voltando recursivamente o método `resolverLeilaoDivisaoEConquista` chama o método `compararListas` que, caso sobre energia, ele verifica se a quantidade total de energia menos a quantidade de energia "comprada" até o momento é maior que zero ( Como podemos ver no: Inseri Empresa Caso Resto Seja Maior Que 0), caso seja, ele busca a empresa cujo valor requerido seja menor ou igual a quantidade de energia restante e o valor seja maior dentre eles, caso a empresa exista, ela é adicionada na lista de empresas selecionadas. Após essa condição ele valida se o conjunto inserido pode ser trocado por alguma empresa que tenha a quantidade requerida menor do que a quantidade total (daquela execução) e o lucro (valor) seja maior, caso exista ele realiza a troca ( como podemos ver no: Realiza Troca).


#### Condição de Parada
```java
    int valorInicial = empresasInteressadas.stream().min(Comparator.comparing(EmpresaInteressada::getQuantRequerida)).orElse(null).getQuantRequerida();
        if(quantidadeEnergiaDisponivel/2 <= valorInicial)
```
    Ou seja, se a proxima divisão for menor que a menor quantidade requerida ele para.


#### Inseri Empresa Caso Resto Seja Maior Que 0
```java
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
```
        Ou seja, ele verifica se existe alguma empresa cuja quantidade requerida seja menor que o resto


#### Realiza Troca
```java
EmpresaInteressada empresaSelecionadaTroca =  empresasInteressadas.stream()
                .filter(e -> e.getQuantRequerida() <= quantidadeEnergiaDisponivel && e.getValor() > finalValorTotal).findFirst().orElse(null);
        if(empresaSelecionadaTroca != null){
            empresasInteressadas.addAll(empresasSelecionadas);
            empresasInteressadas.remove(empresaSelecionadaTroca);
            empresasSelecionadas.clear();
            empresasSelecionadas.add(empresaSelecionadaTroca);
        }
```
    Ou seja, troca as empresas inseridas pela empresa selecionada da troca.


##### Estrutura da Função `Divisão e conquista`


- **Parâmetros**:
    - `quantidadeDisponivel`: Quantidade de recursos ainda disponíveis.
    - `empresasInteressadas`: Lista de todas as empresas interessadas.




#### Detalhes Específicos no Código
Para a Divisão e Conquita eu optei por utilizar a divisão do valor de energia disponivel e execuar a recursividade para a direita e a esquerda


```java
        List<EmpresaInteressada> direita = resolverLeilaoDivisaoEConquista(empresasInteressadas, quantidadeEnergiaDisponivel/2);
        List<EmpresaInteressada> esquerda = resolverLeilaoDivisaoEConquista(empresasInteressadas, quantidadeEnergiaDisponivel/2);
```


Vamos analisar em detalhes:


#### Resultado


O método `InicializaLeilao` retorna um objeto `ResultadoDTO` que contém:
- A melhor seleção de empresas interessadas (`melhorSelecao`).
- O melhor lucro encontrado (`melhorLucro`).
- A quantidade total de recursos vendidos (`quantidadeVendida`).
- O algoritmo utilizado (`AlgoritmoEnum.DIVISAOECONQUISTA`).
