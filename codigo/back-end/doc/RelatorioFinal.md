### Relatório Técnico sobre Implementações e Comparação de Resultados

#### I. Explicações sobre as Decisões Tomadas e o Funcionamento do Algoritmo Implementado

**Algoritmo Implementado: Backtracking**

O método de Backtracking desenvolvido para abordar o desafio da seleção de empresas interessadas utiliza estratégias de otimização baseadas em técnicas de poda, aprimorando a abordagem de força bruta.
No caso do problema apresentado, a solução implementada roda o algoritmo de Backtracking para todas as combinações possíveis, buscando criar a melhor seleção de empresas. Destaca-se a importância crucial da técnica de poda no aprimoramento do processo de busca. Essa abordagem efetiva elimina caminhos desnecessários na árvore de decisão, resultando em uma significativa melhoria na eficiência do algoritmo - que é o que o diferencia de algoritmos força-bruta. Neste contexto, o nosso backtracking emprega a técnica de poda ao verificar se a inclusão de uma nova empresa não ultrapassa a quantidade disponível, e se o lucro acumulado pode ser potencialmente maior que o melhor lucro encontrado até então. Essa técnica de poda ajuda a reduzir o número de combinações a serem exploradas, aumentando a eficiência do algoritmo.

**Decisões Tomadas:**

1. **Escolha do Algoritmo:**
   O algoritmo de backtracking foi escolhido devido à sua capacidade de explorar todas as combinações possíveis de empresas interessadas para maximizar o lucro. O objetivo é encontrar a melhor seleção de empresas que comprem os produtos de uma empresa vendedora, maximizando o lucro sem ultrapassar a quantidade disponível.

2. **Ordenação Inicial:**
   As empresas interessadas foram ordenadas com base na razão entre valor oferecido e quantidade requerida. Isso garante que empresas oferecendo maior valor por unidade sejam consideradas primeiro, potencialmente levando a uma solução ótima mais rapidamente.

3. **Estrutura do Algoritmo:**
   O algoritmo começa no índice 0 das empresas interessadas e tenta incluir ou excluir cada empresa da seleção atual, verificando se a quantidade requerida pela empresa pode ser atendida pela quantidade disponível. O lucro atual é atualizado conforme empresas são incluídas ou excluídas.

4. **Critério de Otimização:**
   A otimização é baseada no lucro máximo possível. Cada vez que uma seleção com maior lucro é encontrada, ela substitui a melhor seleção atual.

5. **Condições de Parada:**
   O algoritmo para quando todas as combinações possíveis foram exploradas ou quando o limite de tempo é excedido.

**Funcionamento do Algoritmo:**

1. **Inicialização:**
   - `melhorLucro` é iniciado com 0.
   - `melhorSelecao` é iniciado como uma lista vazia.

2. **Execução do Algoritmo:**
   - As empresas interessadas são ordenadas.
   - O método `backtrack` é chamado recursivamente, tentando incluir ou excluir cada empresa, atualizando a quantidade disponível e o lucro atual.
   - Ao final de cada ramo de recursão, se o lucro atual for maior que o melhor lucro registrado, a melhor seleção e o melhor lucro são atualizados.

3. **Resultado:**
   - O resultado contém a melhor seleção de empresas, o melhor lucro, a quantidade vendida e o algoritmo utilizado.

#### II. Comparação de Resultados Obtidos pelas Implementações

**Tempo de Execução e Qualidade do Resultado:**

Para analisar a performance do algoritmo de backtracking, foram realizados testes com diferentes tamanhos de entrada, variando de 10 a 77 empresas interessadas. Abaixo está uma tabela que resume os tempos de execução e a média de execução para cada tamanho:

| Tamanho | Execução 1 | Execução 2 | Execução 3 | Execução 4 | Execução 5 | Execução 6 | Execução 7 | Execução 8 | Execução 9 | Execução 10 | Média  |
|---------|------------|------------|------------|------------|------------|------------|------------|------------|------------|-------------|--------|
| 10      | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s         | 0.0 s  |
| 70      | 1 s        | 3 s        | 1 s        | 28 s       | 4 s        | 1 s        | 1 s        | 2 s        | 3 s        | 2 s         | 4.6 s  |
| 71      | 0 s        | 3 s        | 1 s        | 26 s       | 2 s        | 8 s        | 4 s        | 2 s        | 1 s        | 1 s         | 4.8 s  |
| 72      | 4 s        | 3 s        | 6 s        | 4 s        | 1 s        | 0 s        | 2 s        | 1 s        | 1 s        | 8 s         | 3.0 s  |
| 73      | 6 s        | 26 s       | 73 s       | 9 s        | 2 s        | 1 s        | 1 s        | 9 s        | 9 s        | 2 s         | 13.8 s |
| 74      | 65 s       | 4 s        | 20 s       | 6 s        | 25 s       | 0 s        | 0 s        | 6 s        | 11 s       | 17 s        | 15.4 s |
| 75      | 3 s        | 7 s        | 1 s        | 11 s       | 15 s       | 11 s       | 9 s        | 12 s       | 1 s        | 3 s         | 7.3 s  |
| 76      | 1 s        | 30 s       | 0 s        | 18 s       | 4 s        | 2 s        | 2 s        | 469 s      | 0 s        | 295 s       | 82.1 s |

**Resultado da Execução 76**

**Resultado 1**

- **Duração:** 1976839000
- **Algoritmo Utilizado:** BACKTRAKING
- **Melhor Lucro:** 5156.0
- **Quantidade Vendida:** 990
- **Melhor Seleção:**
    - Empresa L63
    - Empresa L31
    - Empresa L3
    - Empresa L42
    - Empresa L22
    - Empresa L4
    - Empresa L70
    - Empresa L8
    - Empresa L61
    - Empresa L67
    - Empresa L71
    - Empresa L24

**Resultado 2**

- **Duração:** 30566570100
- **Algoritmo Utilizado:** BACKTRAKING
- **Melhor Lucro:** 6234.0
- **Quantidade Vendida:** 1000
- **Melhor Seleção:**
    - Empresa L43
    - Empresa L4
    - Empresa L12
    - Empresa L33
    - Empresa L61
    - Empresa L8
    - Empresa L9
    - Empresa L45
    - Empresa L49
    - Empresa L42
    - Empresa L74
    - Empresa L10
    - Empresa L60
    - Empresa L22
    - Empresa L59
    - Empresa L32

**Resultado 3**

- **Duração:** 436243500
- **Algoritmo Utilizado:** BACKTRAKING
- **Melhor Lucro:** 4780.0
- **Quantidade Vendida:** 1000
- **Melhor Seleção:**
    - Empresa L36
    - Empresa L4
    - Empresa L20
    - Empresa L49
    - Empresa L72
    - Empresa L23
    - Empresa L68
    - Empresa L62
    - Empresa L55
    - Empresa L22
    - Empresa L46

**Resultado 4**

- **Duração:** 18441967400
- **Algoritmo Utilizado:** BACKTRAKING
- **Melhor Lucro:** 5605.0
- **Quantidade Vendida:** 1000
- **Melhor Seleção:**
    - Empresa L60
    - Empresa L73
    - Empresa L20
    - Empresa L14
    - Empresa L49
    - Empresa L2
    - Empresa L45
    - Empresa L31
    - Empresa L40
    - Empresa L34
    - Empresa L27
    - Empresa L21

**Resultado 5**

- **Duração:** 4035471700
- **Algoritmo Utilizado:** BACKTRAKING
- **Melhor Lucro:** 5418.0
- **Quantidade Vendida:** 1000
- **Melhor Seleção:**
    - Empresa L31
    - Empresa L58
    - Empresa L49
    - Empresa L1
    - Empresa L30
    - Empresa L40
    - Empresa L26
    - Empresa L68
    - Empresa L17
    - Empresa L61
    - Empresa L34
    - Empresa L65
    - Empresa L62

**Resultado 6**

- **Duração:** 2584133300
- **Algoritmo Utilizado:** BACKTRAKING
- **Melhor Lucro:** 4772.0
- **Quantidade Vendida:** 1000
- **Melhor Seleção:**
    - Empresa L23
    - Empresa L30
    - Empresa L20
    - Empresa L34
    - Empresa L60
    - Empresa L38
    - Empresa L48
    - Empresa L69
    - Empresa L68
    - Empresa L12
    - Empresa L16
    - Empresa L57
    - Empresa L11
    - Empresa L3

**Resultado 7**

- **Duração:** 2344055100
- **Algoritmo Utilizado:** BACKTRAKING
- **Melhor Lucro:** 5284.0
- **Quantidade Vendida:** 990
- **Melhor Seleção:**
    - Empresa L74
    - Empresa L7
    - Empresa L50
    - Empresa L36
    - Empresa L72
    - Empresa L27
    - Empresa L70
    - Empresa L38
    - Empresa L30
    - Empresa L39
    - Empresa L52
    - Empresa L48
    - Empresa L8

**Resultado 8**

- **Duração:** 469728922200
- **Algoritmo Utilizado:** BACKTRAKING
- **Melhor Lucro:** 7983.0
- **Quantidade Vendida:** 990
- **Melhor Seleção:**
    - Empresa L35
    - Empresa L54
    - Empresa L18
    - Empresa L22
    - Empresa L58
    - Empresa L14
    - Empresa L61
    - Empresa L51
    - Empresa L74
    - Empresa L41
    - Empresa L29
    - Empresa L60
    - Empresa L16
    - Empresa L62
    - Empresa L76
    - Empresa L67
    - Empresa L21
    - Empresa L44

**Resultado 9**

- **Duração:** 799764700
- **Algoritmo Utilizado:** BACKTRAKING
- **Melhor Lucro:** 5564.0
- **Quantidade Vendida:** 1000
- **Melhor Seleção:**
    - Empresa L39
    - Empresa L28
    - Empresa L57
    - Empresa L51
    - Empresa L37
    - Empresa L21
    - Empresa L36
    - Empresa L71
    - Empresa L14
    - Empresa L8
    - Empresa L70
    - Empresa L50
    - Empresa L24

**Resultado 10**

- **Duração:** 295182890400
- **Algoritmo Utilizado:** BACKTRAKING
- **Melhor Lucro:** 7707.0
- **Quantidade Vendida:** 1000
- **Melhor Seleção:**
    - Empresa L37
    - Empresa L5
    - Empresa L18
    - Empresa L54
    - Empresa L26
    - Empresa L29
    - Empresa L66
    - Empresa L58
    - Empresa L45
    - Empresa L16
    - Empresa L3
    - Empresa L4
    - Empresa L17
    - Empresa L40
    - Empresa L50
    - Empresa L52
    - Empresa L61
    - Empresa L62
    - Empresa L46
    - Empresa L55

**Observações:**
- O algoritmo apresentou uma variabilidade significativa no tempo de execução, especialmente para tamanhos maiores de entrada.
- Para entradas menores, o tempo de execução foi consistentemente rápido, porém, para tamanhos acima de 63 empresas, houve um aumento notável na variabilidade e no tempo médio de execução.
- A média de tempo de execução mostra que o algoritmo é eficiente para tamanhos de entrada até 62 empresas, após o qual o tempo de execução tende a aumentar de forma significativa.

**Análise dos Resultados:**

- **Desempenho em Pequenos Tamanhos:**
  Para tamanhos menores ou iguais a 61, o algoritmo executou rapidamente, em menos de 1 segundo, na maioria dos casos.

- **Desempenho em Tamanhos Maiores:**
  Para tamanhos maiores que 61, o tempo de execução começou a variar significativamente, com algumas execuções levando mais de um minuto. Isso reflete a complexidade do problema combinatório e a natureza exponencial do algoritmo de backtracking.

- **Estabilidade:**
  Observa-se que para alguns tamanhos, como 77, o tempo de execução variou amplamente, com a média sendo afetada por algumas execuções muito longas. Isso indica que o algoritmo pode ser sensível a diferentes conjuntos de dados para tamanhos maiores, devido a sua natureza exponencial.

### Conclusão

O algoritmo de backtracking implementado é eficaz na maximização do lucro para o problema de seleção de empresas interessadas. No entanto, a eficiência temporal se torna um desafio conforme o tamanho da entrada aumenta. Para entradas maiores, a variabilidade no tempo de execução indica a necessidade de potencial otimização ou a consideração de algoritmos alternativos que possam lidar melhor com a escalabilidade.


