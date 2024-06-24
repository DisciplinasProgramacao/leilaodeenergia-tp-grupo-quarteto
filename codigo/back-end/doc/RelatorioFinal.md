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


#### II. Explicações sobre as Decisões Tomadas e o Funcionamento do Algoritmo Implementado

**Algoritmo Implementado: Greedy1**

O método de Greedy (guloso) desenvolvido para abordar o desafio da seleção de empresas interessadas utiliza uma estratégia baseada na escolha local ótima, visando encontrar uma solução que maximize o lucro de maneira eficiente.

**Decisões Tomadas:**

1. **Escolha do Algoritmo:**
  O algoritmo guloso foi escolhido devido à sua simplicidade e eficiência em encontrar uma solução aproximada em tempo razoável. Este método é particularmente eficaz quando há uma clara estratégia para ordenar e selecionar as empresas interessadas de forma a maximizar o lucro rapidamente.

2. **Ordenação Inicial:**
   As empresas interessadas foram ordenadas com base na razão entre valor oferecido e quantidade requerida. Isso garante que empresas oferecendo maior valor por unidade sejam consideradas primeiro, potencialmente levando a uma solução próxima da ótima de forma mais rápida.

3. **Estrutura do Algoritmo:**
   O algoritmo percorre a lista de empresas interessadas, incluindo aquelas cujas quantidades requeridas podem ser atendidas pela quantidade disponível da empresa vendedora. A cada inclusão, o lucro total é atualizado e a quantidade disponível é reduzida.

4. **Critério de Otimização:**
   A otimização é baseada no lucro máximo possível. Empresas são selecionadas em ordem decrescente da razão valor/quantidade, garantindo que o lucro seja maximizado em cada passo.

5. **Condições de Parada:**
   O algoritmo para quando todas as empresas foram consideradas ou quando a quantidade disponível da empresa vendedora é insuficiente para atender qualquer outra empresa interessada.

**Funcionamento do Algoritmo:**

1. **Inicialização:**
   - `melhorLucro` é iniciado com 0.
   - `melhorSelecao` é iniciado como uma lista vazia.

2. **Execução do Algoritmo:**
   - As empresas interessadas são ordenadas.
   - O algoritmo percorre a lista ordenada, tentando incluir cada empresa se a quantidade requerida puder ser atendida pela quantidade disponível.
   - Ao final de cada inclusão, o lucro atual é atualizado conforme empresas são incluídas na seleção.

3. **Resultado:**
   - O resultado contém a melhor seleção de empresas, o melhor lucro, a quantidade vendida e o algoritmo utilizado.

#### IV. Comparação de Resultados Obtidos pelas Implementações

**Tempo de Execução e Qualidade do Resultado:**

Para analisar a performance do algoritmo de Guloso, foram realizados testes com diferentes tamanhos de entrada, variando as empresas interessadas. Abaixo está uma tabela que resume os tempos de execução e a média de execução para cada tamanho:

Lógica aplicada: e.getValor() / e.getQuantRequerida()

| Tamanho | Execução 1 | Execução 2 | Execução 3 | Execução 4 | Execução 5 | Execução 6 | Execução 7 | Execução 8 | Execução 9 | Execução 10 | Média  |
|---------|------------|------------|------------|------------|------------|------------|------------|------------|------------|-------------|--------|
| 76      | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s         | 0 s    |
| 152     | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s         | 0 s    |
| 228     | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s         | 0 s    |
| 304     | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s         | 0 s    |
| 380     | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s         | 0 s    |
| 456     | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s         | 0 s    |
| 532     | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s         | 0 s    |
| 608     | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s         | 0 s    |
| 684     | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s         | 0 s    |
| 760     | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s         | 0 s    |

**Resultado da Execução 76**

**Resultado 1**

- **Duração:** 1411900
- **Algoritmo Utilizado:** GREEDYUNITARIO
- **Melhor Lucro:** 5485.0
- **Quantidade Vendida:** 960
- **Melhor Seleção:**
    - Empresa L72
    - Empresa L41
    - Empresa L47
    - Empresa L4
    - Empresa L24
    - Empresa L49
    - Empresa L14
    - Empresa L61
    - Empresa L15
    - Empresa L75
    - Empresa L26
    - Empresa L37
    - Empresa L6

**Resultado 2**

- **Duração:** 105300
- **Algoritmo Utilizado:** GREEDYUNITARIO
- **Melhor Lucro:** 7464.0
- **Quantidade Vendida:** 960
- **Melhor Seleção:**
    - Empresa L56
    - Empresa L48
    - Empresa L2
    - Empresa L4
    - Empresa L5
    - Empresa L70
    - Empresa L64
    - Empresa L57
    - Empresa L45
    - Empresa L22
    - Empresa L65
    - Empresa L31
    - Empresa L63
    - Empresa L13
    - Empresa L73
    - Empresa L67
    - Empresa L42

**Resultado 3**

- **Duração:** 76300
- **Algoritmo Utilizado:** GREEDYUNITARIO
- **Melhor Lucro:** 5290.0
- **Quantidade Vendida:** 1000
- **Melhor Seleção:**
    - Empresa L26
    - Empresa L30
    - Empresa L1
    - Empresa L4
    - Empresa L13
    - Empresa L5
    - Empresa L32
    - Empresa L40
    - Empresa L28
    - Empresa L19
    - Empresa L64
    - Empresa L48
    - Empresa L58

**Resultado 4**

- **Duração:** 75800
- **Algoritmo Utilizado:** GREEDYUNITARIO
- **Melhor Lucro:** 4938.0
- **Quantidade Vendida:** 920
- **Melhor Seleção:**
    - Empresa L30
    - Empresa L71
    - Empresa L11
    - Empresa L6
    - Empresa L48
    - Empresa L72
    - Empresa L1
    - Empresa L47
    - Empresa L70
    - Empresa L42
    - Empresa L74
    - Empresa L26
    - Empresa L34

**Resultado 5**

- **Duração:** 78600
- **Algoritmo Utilizado:** GREEDYUNITARIO
- **Melhor Lucro:** 4112.0
- **Quantidade Vendida:** 980
- **Melhor Seleção:**
    - Empresa L41
    - Empresa L26
    - Empresa L50
    - Empresa L38
    - Empresa L75
    - Empresa L66
    - Empresa L36
    - Empresa L43
    - Empresa L6
    - Empresa L67
    - Empresa L62
    - Empresa L4

**Resultado 6**

- **Duração:** 74800
- **Algoritmo Utilizado:** GREEDYUNITARIO
- **Melhor Lucro:** 5724.0
- **Quantidade Vendida:** 1000
- **Melhor Seleção:**
    - Empresa L26
    - Empresa L41
    - Empresa L56
    - Empresa L40
    - Empresa L45
    - Empresa L60
    - Empresa L10
    - Empresa L27
    - Empresa L55
    - Empresa L57
    - Empresa L39
    - Empresa L61
    - Empresa L42
    - Empresa L1
    - Empresa L28
    - Empresa L51
    - Empresa L46

**Resultado 7**

- **Duração:** 76700
- **Algoritmo Utilizado:** GREEDYUNITARIO
- **Melhor Lucro:** 6214.0
- **Quantidade Vendida:** 1000
- **Melhor Seleção:**
    - Empresa L47
    - Empresa L19
    - Empresa L73
    - Empresa L26
    - Empresa L75
    - Empresa L76
    - Empresa L64
    - Empresa L21
    - Empresa L20
    - Empresa L66
    - Empresa L44
    - Empresa L39
    - Empresa L72
    - Empresa L29
    - Empresa L42

**Resultado 8**

- **Duração:** 78400
- **Algoritmo Utilizado:** GREEDYUNITARIO
- **Melhor Lucro:** 5030.0
- **Quantidade Vendida:** 980
- **Melhor Seleção:**
    - Empresa L56
    - Empresa L1
    - Empresa L58
    - Empresa L15
    - Empresa L25
    - Empresa L3
    - Empresa L74
    - Empresa L2
    - Empresa L72
    - Empresa L35
    - Empresa L30
    - Empresa L12
    - Empresa L75
    - Empresa L51

**Resultado 9**

- **Duração:** 104400
- **Algoritmo Utilizado:** GREEDYUNITARIO
- **Melhor Lucro:** 4259.0
- **Quantidade Vendida:** 990
- **Melhor Seleção:**
    - Empresa L14
    - Empresa L73
    - Empresa L21
    - Empresa L66
    - Empresa L60
    - Empresa L29
    - Empresa L17
    - Empresa L47
    - Empresa L4
    - Empresa L69

**Resultado 10**

- **Duração:** 76300
- **Algoritmo Utilizado:** GREEDYUNITARIO
- **Melhor Lucro:** 5844.0
- **Quantidade Vendida:** 950
- **Melhor Seleção:**
    - Empresa L51
    - Empresa L75
    - Empresa L3
    - Empresa L29
    - Empresa L12
    - Empresa L1
    - Empresa L45
    - Empresa L43
    - Empresa L65
    - Empresa L64
    - Empresa L50
    - Empresa L2
    - Empresa L52
    - Empresa L42

**Observações:**
- O algoritmo apresentou uma performance estável em termos de tempo de execução, sendo consistentemente rápido, independentemente do tamanho da entrada.
- A variabilidade observada nos tempos de execução é mínima, com tempos de execução próximos a zero segundos para todos os tamanhos de entrada testados.
- Isso demonstra que o algoritmo guloso é eficiente e escalável, mesmo para entradas maiores.

**Análise dos Resultados:**

- **Desempenho em Pequenos Tamanhos:**
  Para todos os tamanhos testados, o algoritmo guloso executou rapidamente, em menos de 1 segundo.

- **Desempenho em Tamanhos Maiores:**
  Mesmo para os maiores tamanhos testados (até 760 empresas), o algoritmo manteve tempos de execução extremamente rápidos, demonstrando uma excelente escalabilidade.

- **Estabilidade:**
  A estabilidade do tempo de execução é um ponto forte do algoritmo guloso, que se mostrou consistentemente eficiente e rápido, independentemente do tamanho da entrada.

### Conclusão

O algoritmo guloso implementado se mostrou altamente eficaz na maximização do lucro para o problema de seleção de empresas interessadas. Sua eficiência temporal é destacável, com tempos de execução rápidos e consistentes para todos os tamanhos de entrada testados. Isso torna o algoritmo uma escolha sólida e prática para problemas de otimização que envolvem grandes volumes de dados, apresentando uma solução escalável e eficiente.


#### III. Explicações sobre as Decisões Tomadas e o Funcionamento do Algoritmo Implementado

**Algoritmo Implementado: Greedy2**

O método de Greedy (guloso) desenvolvido para abordar o desafio da seleção de empresas interessadas utiliza uma estratégia baseada na escolha local ótima, visando encontrar uma solução que maximize o lucro de maneira eficiente.

**Decisões Tomadas:**

1. **Escolha do Algoritmo:**
  O algoritmo guloso foi escolhido devido à sua simplicidade e eficiência em encontrar uma solução aproximada em tempo razoável. Este método é particularmente eficaz quando há uma clara estratégia para ordenar e selecionar as empresas interessadas de forma a maximizar o lucro rapidamente.

2. **Ordenação Inicial:**
   As empresas interessadas foram ordenadas com base nos valor oferecido em ordem decrescente. Isso garante que empresas oferecendo maior valor sejam consideradas primeiro, potencialmente levando a uma solução próxima da ótima de forma mais rápida.

3. **Estrutura do Algoritmo:**
   O algoritmo percorre a lista de empresas interessadas, incluindo aquelas cujas quantidades requeridas podem ser atendidas pela quantidade disponível da empresa vendedora. A cada inclusão, o lucro total é atualizado e a quantidade disponível é reduzida.

4. **Critério de Otimização:**
   A otimização é baseada no lucro máximo possível. Empresas são selecionadas em ordem decrescente do valor, garantindo que o lucro seja maximizado em cada passo.

5. **Condições de Parada:**
   O algoritmo para quando todas as empresas foram consideradas ou quando a quantidade disponível da empresa vendedora é insuficiente para atender qualquer outra empresa interessada.

**Funcionamento do Algoritmo:**

1. **Inicialização:**
   - `melhorLucro` é iniciado com 0.
   - `melhorSelecao` é iniciado como uma lista vazia.

2. **Execução do Algoritmo:**
   - As empresas interessadas são ordenadas.
   - O algoritmo percorre a lista ordenada, tentando incluir cada empresa se a quantidade requerida puder ser atendida pela quantidade disponível.
   - Ao final de cada inclusão, o lucro atual é atualizado conforme empresas são incluídas na seleção.

3. **Resultado:**
   - O resultado contém a melhor seleção de empresas, o melhor lucro, a quantidade vendida e o algoritmo utilizado.

#### VI. Comparação de Resultados Obtidos pelas Implementações

**Tempo de Execução e Qualidade do Resultado:**

Para analisar a performance do algoritmo de Guloso, foram realizados testes com diferentes tamanhos de entrada, variando as empresas interessadas. Abaixo está uma tabela que resume os tempos de execução e a média de execução para cada tamanho:

Lógica aplicada: e.getValor()

| Tamanho | Execução 1 | Execução 2 | Execução 3 | Execução 4 | Execução 5 | Execução 6 | Execução 7 | Execução 8 | Execução 9 | Execução 10 | Média  |
|---------|------------|------------|------------|------------|------------|------------|------------|------------|------------|-------------|--------|
| 76      | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s         | 0 s    |
| 152     | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s         | 0 s    |
| 228     | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s         | 0 s    |
| 304     | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s         | 0 s    |
| 380     | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s         | 0 s    |
| 456     | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s         | 0 s    |
| 532     | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s         | 0 s    |
| 608     | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s         | 0 s    |
| 684     | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s         | 0 s    |
| 760     | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s         | 0 s    |

**Resultado da Execução 76**

**Resultado 1**

- **Duração:** 1186700
- **Algoritmo Utilizado:** GREEDYVALORDESC
- **Melhor Lucro:** 2849.0
- **Quantidade Vendida:** 1000
- **Melhor Seleção:**
    - Empresa L35
    - Empresa L45
    - Empresa L49
    - Empresa L39
    - Empresa L24

**Resultado 2**

- **Duração:** 97900
- **Algoritmo Utilizado:** GREEDYVALORDESC
- **Melhor Lucro:** 4536.0
- **Quantidade Vendida:** 1000
- **Melhor Seleção:**
    - Empresa L16
    - Empresa L5
    - Empresa L13
    - Empresa L38
    - Empresa L45
    - Empresa L4
    - Empresa L48
    - Empresa L56
    - Empresa L70

**Resultado 3**

- **Duração:** 72800
- **Algoritmo Utilizado:** GREEDYVALORDESC
- **Melhor Lucro:** 2021.0
- **Quantidade Vendida:** 1000
- **Melhor Seleção:**
    - Empresa L71
    - Empresa L39
    - Empresa L26
    - Empresa L30

**Resultado 4**

- **Duração:** 71800
- **Algoritmo Utilizado:** GREEDYVALORDESC
- **Melhor Lucro:** 3885.0
- **Quantidade Vendida:** 1000
- **Melhor Seleção:**
    - Empresa L5
    - Empresa L26
    - Empresa L71
    - Empresa L48
    - Empresa L30
    - Empresa L70
    - Empresa L6
    - Empresa L11

**Resultado 5**

- **Duração:** 71000
- **Algoritmo Utilizado:** GREEDYVALORDESC
- **Melhor Lucro:** 2911.0
- **Quantidade Vendida:** 990
- **Melhor Seleção:**
    - Empresa L38
    - Empresa L49
    - Empresa L75
    - Empresa L67
    - Empresa L66
    - Empresa L41

**Resultado 6**

- **Duração:** 68600
- **Algoritmo Utilizado:** GREEDYVALORDESC
- **Melhor Lucro:** 2337.0
- **Quantidade Vendida:** 1000
- **Melhor Seleção:**
    - Empresa L49
    - Empresa L66
    - Empresa L26
    - Empresa L41
    - Empresa L40
    - Empresa L56

**Resultado 7**

- **Duração:** 74100
- **Algoritmo Utilizado:** GREEDYVALORDESC
- **Melhor Lucro:** 3757.0
- **Quantidade Vendida:** 980
- **Melhor Seleção:**
    - Empresa L24
    - Empresa L59
    - Empresa L47
    - Empresa L75
    - Empresa L20
    - Empresa L19
    - Empresa L73

**Resultado 8**

- **Duração:** 73100
- **Algoritmo Utilizado:** GREEDYVALORDESC
- **Melhor Lucro:** 3798.0
- **Quantidade Vendida:** 990
- **Melhor Seleção:**
    - Empresa L1
    - Empresa L27
    - Empresa L53
    - Empresa L56
    - Empresa L58
    - Empresa L35
    - Empresa L15

**Resultado 9**

- **Duração:** 75700
- **Algoritmo Utilizado:** GREEDYVALORDESC
- **Melhor Lucro:** 2704.0
- **Quantidade Vendida:** 980
- **Melhor Seleção:**
    - Empresa L33
    - Empresa L60
    - Empresa L21
    - Empresa L73
    - Empresa L66

**Resultado 10**

- **Duração:** 80000
- **Algoritmo Utilizado:** GREEDYVALORDESC
- **Melhor Lucro:** 3752.0
- **Quantidade Vendida:** 1000
- **Melhor Seleção:**
    - Empresa L3
    - Empresa L16
    - Empresa L70
    - Empresa L51
    - Empresa L34
    - Empresa L75
    - Empresa L1

**Observações:**
- O algoritmo apresentou uma performance estável em termos de tempo de execução, sendo consistentemente rápido, independentemente do tamanho da entrada.
- A variabilidade observada nos tempos de execução é mínima, com tempos de execução próximos a zero segundos para todos os tamanhos de entrada testados.
- Isso demonstra que o algoritmo guloso é eficiente e escalável, mesmo para entradas maiores.

**Análise dos Resultados:**

- **Desempenho em Pequenos Tamanhos:**
  Para todos os tamanhos testados, o algoritmo guloso executou rapidamente, em menos de 1 segundo.

- **Desempenho em Tamanhos Maiores:**
  Mesmo para os maiores tamanhos testados (até 760 empresas), o algoritmo manteve tempos de execução extremamente rápidos, demonstrando uma excelente escalabilidade.

- **Estabilidade:**
  A estabilidade do tempo de execução é um ponto forte do algoritmo guloso, que se mostrou consistentemente eficiente e rápido, independentemente do tamanho da entrada.

### Conclusão

O algoritmo guloso implementado não se mostrou tão eficaz na maximização dos lucros para o problema de seleção de empresas interessadas. Ordena as empresas apenas pelo valor total oferecido, o que pode levar à seleção de empresas que oferecem um grande valor total, mas não necessariamente o maior valor por unidade.Embora tenha mantido uma boa performance em termos de tempo de execução, a qualidade do lucro foi inferior em várias execuções. Em várias execuções, o lucro obtido foi significativamente menor do que o obtido por Greedy1.



#### IV. Explicações sobre as Decisões Tomadas e o Funcionamento do Algoritmo Implementado

**Algoritmo Implementado: Divisão e Conquista**

O método de Divisão e Conquista desenvolvido para abordar o desafio da seleção de empresas interessadas utiliza estratégias de dividir o valor da energia disponível baseando-se em técnicas de divisão e conquista (como a abordada em sala).
No caso do problema apresentado, a solução implementada roda o algoritmo recursivo de Divisão e Conquista dividindo o valor de energia disponivel no leilão até se aproximar da menor quantidade requerida pelas empresas interessadas. Voltando recursivamente, para cada divisão executada ele busca a empresa cuja quantidade requerida seja menor que a quantidade disponível (para aquela divisão) e o valor seja o maior dentre estas (usando strem().filter(...).max(...)), caso encontre ele insere essa emporesa, isso ocorre tanto para a direita quanto para a esquerda. Ao comparar os dois lados, o algoritimo valida se existe algum espaço disponível, e insere a empre interessada que caiba no espaço disponível, com a mesma regra citada anteriormente. Após esse processo é realizado a comparação de troca, onde é validado se existe alguma empresa cuja quantidade interessada é menor que a total disponível, e o valor é maior do que o já inserido, caso exista, ele troca o conjunto por essa determinada empresa.   

**Decisões Tomadas:**

1. **Escolha do Algoritmo:**
   O algoritmo de Divisão e Conquista foi escolhido devido à sua capacidade de dividir o problema em problemas cada vez menores, O objetivo é encontrar a melhor seleção de empresas que comprem os produtos de uma empresa vendedora, maximizando o lucro sem ultrapassar a quantidade disponível.

2. **Estrutura do Algoritmo:**
   O algoritmo começa com o valor total disponivel para leilão (por exemplo 1000) e divide esse valor até se aproximar do menor quantidade requerida dentre as empresas interessadas ou seja, quanto a proxima divisão foi menor que  a menor quantidade requerida ele adiciona a empresa e retorna iniciando a recursividade. Para cada divisão é executado o método de comparar listas, que junta o lado esquerdo e direito, e caso ainda sobre energia e exista alguma empresa interessada cuja quantidade requeria seja menor ou igual a sobre, ele pega a que tem o menor valor dentre elas e inseri. Nesse método tambem é realizado a troca, onde caso exista uma empresa cuja quantidade requerida seja menor que a quantidade total disponível e o valor for maior que o valor total inserido, ele remove o conjunto e adiciona a empresa.

3. **Critério de Otimização:**
   Da forma como o algoritmo foi implementado, se trona eficiente (frente aos testes realizados) pois irá fazer um quantidade de operações semelhante para leilões com valores de energia disponiveis iguais, caso desconsiderarmos o "strem().filter(...).max(...)" e a "poda" realizada que limita a divisão do valores de energia disponivel quando ele está proxima da menor quantidade requerida dentre as empresas interessadas (ou sejan quando a proxima divisão será menor que a menor quantidade requerida dentre as empresas interessadas, rele retorna).

4. **Condições de Parada:**
   O algoritmo para quando o valor dividido (total de energia disponível) se aproxima da menor quantidade requerida dentre as empresas interessadas.

**Funcionamento do Algoritmo:**

1. **Execução do Algoritmo:**
   - O valor total de energia disponivel é dividido em chamadas recursivas até se aproximas da menor quantidade requerida dentre as empresas interessadase.
   - para cada divisão o método `compararListas` é chamado, juntando as listas do lado esquerdo e direito, adicionando empresa com melhor lucro caso tenha espaço, e realizando trocas quando necessário.

3. **Resultado:**
   - O resultado contém a melhor seleção de empresas, o melhor lucro, a quantidade vendida e o algoritmo utilizado.

#### II. Comparação de Resultados Obtidos pelas Implementações

**Tempo de Execução e Qualidade do Resultado:**

Para analisar a performance do algoritmo de Divisão e Conquista, foram realizados testes com os conjuntos encontrados no Backtraking, com empresas de tamanho 10 a 76 como mostrado abaixo. 

Tamanho	Execução 1	Execução 2	Execução 3 	Execução 4	Execução 5	Execução 6	Execução 7	Execução 8	Execução 9	Execução 10
10	        0 s	        0 s	        0 s	        0 s	        0 s	        0 s	        0 s	        0 s	        0 s	        0 s
70	        0 s	        0 s	        0 s	        0 s	        0 s	        0 s	        0 s	        0 s	        0 s	        0 s
71	        0 s	        0 s	        0 s	        0 s	        0 s	        0 s	        0 s	        0 s	        0 s	        0 s
72	        0 s	        0 s	        0 s	        0 s	        0 s	        0 s	        0 s	        0 s	        0 s	        0 s
73	        0 s	        0 s	        0 s	        0 s	        0 s	        0 s	        0 s	        0 s	        0 s	        0 s
74	        0 s	        0 s	        0 s	        0 s	        0 s	        0 s	        0 s	        0 s	        0 s	        0 s
75	        0 s	        0 s	        0 s	        0 s	        0 s	        0 s	        0 s	        0 s	        0 s	        0 s
76	        0 s	        0 s	        0 s	        0 s	        0 s	        0 s	        0 s	        0 s	        0 s	        0 s

Como citado anterioemente, da forma como o algoritmo foi implementado, se trona eficiente (frente aos testes realizados) pois irá fazer um quantidade de operações semelhante para leilões com valores de energia disponiveis iguais (Como o caso acima onde o valor de energia total considerado para todas as execuções foi de 1000), caso desconsiderarmos o "strem().filter(...).max(...)" e a "poda" realizada que limita a divisão do valores de energia disponivel quando ele está proxima da menor quantidade requerida dentre as empresas interessadas (ou sejan quando a proxima divisão será menor que a menor quantidade requerida dentre as empresas interessadas, rele retorna).
Podemos dizer então, que o tempo de execução do algoritmo almenta significamente com o almento da quantidade de energia disponível, e não com as empresas interessadas. Por exemplo, quanto o algoritmo foi exposto a uma quantidade de energia que se aproximava de 9 milhoe, ele teve o tempo consideravelmente almentado.

**Resultado da Execução 76**

**Resultado 1**

- **Duração:** 739500
- **Algoritmo Utilizado:** DIVISAOECONQUISTA
- **Melhor Lucro:** 4547.0
- **Quantidade Vendida:** 960
- **Melhor Seleção:**
    - Empresa L3
    - Empresa L31
    - Empresa L63
    - Empresa L13
    - Empresa L42
    - Empresa L70
    - Empresa L4
    - Empresa L22
    - Empresa L61
    - Empresa L8
    - Empresa L1
    - Empresa L24

**Resultado 2**

- **Duração:** 853500
- **Algoritmo Utilizado:** DIVISAOECONQUISTA
- **Melhor Lucro:** 5850.0
- **Quantidade Vendida:** 930
- **Melhor Seleção:**
    - Empresa L43
    - Empresa L4
    - Empresa L12
    - Empresa L32
    - Empresa L33
    - Empresa L45
    - Empresa L10
    - Empresa L61
    - Empresa L22
    - Empresa L49
    - Empresa L8
    - Empresa L9
    - Empresa L13
    - Empresa L65
    - Empresa L42

**Resultado 3**

- **Duração:** 1,240,000
- **Algoritmo Utilizado:** DIVISAOECONQUISTA
- **Melhor Lucro:** 4674.0
- **Quantidade Vendida:** 990
- **Melhor Seleção:**
   - Empresa L4
   - Empresa L20
   - Empresa L36
   - Empresa L49
   - Empresa L72
   - Empresa L22
   - Empresa L68
   - Empresa L23
   - Empresa L10
   - Empresa L62
   - Empresa L55
   - Empresa L35

**Resultado 4**

- **Duração:** 1,047,400
- **Algoritmo Utilizado:** DIVISAOECONQUISTA
- **Melhor Lucro:** 5306.0
- **Quantidade Vendida:** 1000
- **Melhor Seleção:**
    - Empresa L60
    - Empresa L20
    - Empresa L14
    - Empresa L73
    - Empresa L33
    - Empresa L49
    - Empresa L45
    - Empresa L31
    - Empresa L40
    - Empresa L65
    - Empresa L2
    - Empresa L3
    - Empresa L32

**Resultado 5**

- **Duração:** 1,195,700
- **Algoritmo Utilizado:** DIVISAOECONQUISTA
- **Melhor Lucro:** 4607.0
- **Quantidade Vendida:** 990
- **Melhor Seleção:**
    - Empresa L30
    - Empresa L23
    - Empresa L34
    - Empresa L20
    - Empresa L12
    - Empresa L38
    - Empresa L48
    - Empresa L69
    - Empresa L60
    - Empresa L68
    - Empresa L57
    - Empresa L16
    - Empresa L3
    - Empresa L58
    - Empresa L14

**Resultado 6**

- **Duração:** 1,165,000
- **Algoritmo Utilizado:** DIVISAOECONQUISTA
- **Melhor Lucro:** 4803.0
- **Quantidade Vendida:** 910
- **Melhor Seleção:**
    - Empresa L49
    - Empresa L30
    - Empresa L1
    - Empresa L58
    - Empresa L31
    - Empresa L40
    - Empresa L26
    - Empresa L61
    - Empresa L68
    - Empresa L43
    - Empresa L15
    - Empresa L65
    - Empresa L70

**Resultado 7**

- **Duração:** 1,156,200
- **Algoritmo Utilizado:** DIVISAOECONQUISTA
- **Melhor Lucro:** 4607.0
- **Quantidade Vendida:** 990
- **Melhor Seleção:**
    - Empresa L30
    - Empresa L23
    - Empresa L34
    - Empresa L20
    - Empresa L12
    - Empresa L38
    - Empresa L48
    - Empresa L69
    - Empresa L60
    - Empresa L68
    - Empresa L57
    - Empresa L16
    - Empresa L3
    - Empresa L58
    - Empresa L14

**Resultado 8**

- **Duração:** 1,156,200
- **Algoritmo Utilizado:** DIVISAOECONQUISTA
- **Melhor Lucro:** 7462.0
- **Quantidade Vendida:** 940
- **Melhor Seleção:**
    - Empresa L35
    - Empresa L58
    - Empresa L61
    - Empresa L54
    - Empresa L18
    - Empresa L51
    - Empresa L22
    - Empresa L14
    - Empresa L47
    - Empresa L74
    - Empresa L21
    - Empresa L10
    - Empresa L56
    - Empresa L29
    - Empresa L60
    - Empresa L41
    - Empresa L67
    - Empresa L16

**Resultado 9**
- **Duração:** 1,375,600
- **Algoritmo Utilizado:** DIVISAOECONQUISTA
- **Melhor Lucro:** 5361.0
- **Quantidade Vendida:** 880
- **Melhor Seleção:**
    - Empresa L72
    - Empresa L39
    - Empresa L28
    - Empresa L57
    - Empresa L21
    - Empresa L37
    - Empresa L36
    - Empresa L71
    - Empresa L8
    - Empresa L14
    - Empresa L51
    - Empresa L24
    - Empresa L50

**Resultado 10**

- **Duração:** 1,409,400
- **Algoritmo Utilizado:** DIVISAOECONQUISTA
- **Melhor Lucro:** 7676.0
- **Quantidade Vendida:** 950
- **Melhor Seleção:**
    - Empresa L37
    - Empresa L5
    - Empresa L18
    - Empresa L26
    - Empresa L54
    - Empresa L29
    - Empresa L45
    - Empresa L3
    - Empresa L4
    - Empresa L50
    - Empresa L2
    - Empresa L16
    - Empresa L17
    - Empresa L40
    - Empresa L61
    - Empresa L66
    - Empresa L58
    - Empresa L52
    - Empresa L22
    - Empresa L46
    - Empresa L62

**Observações:**
- O algoritmo apresentou uma tempo de execução bem proximo, como pedemos ver no resultado, isso se deve ao que foi explicado anteriormente. Porem o algoritmo não se mostrou tão preciso quanto o backtraking, juntamente pela sua caracteristica de ao juntar os conjuntos ele optar por trocar o conjunto como um todo por outro item melhor, e não o item de seu conjunto.

**Análise dos Resultados:**

- **Desempenho em Tamanhos:**
 O algoritmo demostrou um tempo bem parecido idependente da quantidade de empresas interessadas justamente pela caracteristica já explicada no relatório.

- **Resultado:**
O algoritmo não se mostrou tão preciso quanto o backtraking, juntamente pela sua caracteristica de ao juntar os conjuntos ele optar por trocar o conjunto como um todo por outro item melhor, e não o item de seu conjunto, essa é uma caracteristica do próprio divisão e conquita, conforme pode ser observado nos slaides do professor ou em sala de aula.

### Conclusão

O algoritmo de Divisão e Conquista implementado é eficaz no tempo de resposta para o conjunto estudado do problema de seleção de empresas interessadas. No entanto, a precisão no resultado se torna um desafio devido as suas caracteristicas de troca. Em relação ao tempo de execução, sua execução varia quando almentamos a quantidade de enegia disponível, devida a abordagem da recursividade.
