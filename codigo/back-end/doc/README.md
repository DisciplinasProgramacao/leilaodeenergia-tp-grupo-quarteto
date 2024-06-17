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

| Tamanho | Execução 1 | Execução 2 | Execução 3 | Execução 4 | Execução 5 | Execução 6 | Execução 7 | Execução 8 | Execução 9 | Execução 10 | Média   |
|---------|------------|------------|------------|------------|------------|------------|------------|------------|------------|-------------|---------|
| 10      | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s         | 0.0 s   |
| 56      | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s         | 0.0 s   |
| 57      | 0 s        | 0 s        | 1 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s         | 0.1 s   |
| 58      | 0 s        | 0 s        | 6 s        | 1 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s         | 0.7 s   |
| 59      | 0 s        | 2 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 12 s       | 0 s         | 1.4 s   |
| 60      | 0 s        | 0 s        | 5 s        | 0 s        | 0 s        | 1 s        | 0 s        | 0 s        | 0 s        | 0 s         | 0.6 s   |
| 61      | 0 s        | 0 s        | 0 s        | 0 s        | 1 s        | 1 s        | 0 s        | 1 s        | 0 s        | 2 s         | 0.5 s   |
| 62      | 0 s        | 1 s        | 1 s        | 0 s        | 0 s        | 1 s        | 0 s        | 0 s        | 3 s        | 1 s         | 0.7 s   |
| 63      | 0 s        | 4 s        | 4 s        | 0 s        | 0 s        | 65 s       | 5 s        | 1 s        | 0 s        | 0 s         | 7.9 s   |
| 64      | 0 s        | 0 s        | 0 s        | 11 s       | 0 s        | 2 s        | 3 s        | 0 s        | 1 s        | 1 s         | 1.8 s   |
| 65      | 0 s        | 32 s       | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s         | 3.2 s   |
| 66      | 0 s        | 0 s        | 0 s        | 0 s        | 23 s       | 0 s        | 8 s        | 2 s        | 1 s        | 4 s         | 3.8 s   |
| 67      | 0 s        | 1 s        | 0 s        | 13 s       | 4 s        | 4 s        | 8 s        | 0 s        | 2 s        | 3 s         | 3.5 s   |
| 68      | 0 s        | 0 s        | 1 s        | 6 s        | 4 s        | 0 s        | 3 s        | 0 s        | 2 s        | 0 s         | 1.6 s   |
| 69      | 0 s        | 0 s        | 0 s        | 2 s        | 5 s        | 33 s       | 1 s        | 11 s       | 1 s        | 4 s         | 5.7 s   |
| 70      | 0 s        | 2 s        | 0 s        | 2 s        | 5 s        | 3 s        | 12 s       | 2 s        | 35 s       | 57 s        | 11.8 s  |
| 71      | 0 s        | 0 s        | 1 s        | 20 s       | 0 s        | 1 s        | 0 s        | 37 s       | 0 s        | 23 s        | 8.2 s   |
| 72      | 0 s        | 18 s       | 2 s        | 1 s        | 2 s        | 8 s        | 3 s        | 1 s        | 2 s        | 5 s         | 4.2 s   |
| 73      | 0 s        | 20 s       | 16 s       | 5 s        | 6 s        | 0 s        | 18 s       | 1 s        | 5 s        | 2 s         | 7.3 s   |
| 74      | 0 s        | 29 s       | 12 s       | 3 s        | 11 s       | 3 s        | 2 s        | 6 s        | 0 s        | 3 s         | 6.9 s   |
| 75      | 0 s        | 17 s       | 25 s       | 3 s        | 12 s       | 17 s       | 2 s        | 3 s        | 10 s       | 3 s         | 9.2 s   |
| 76      | 0 s        | 10 s       | 6 s        | 3 s        | 2 s        | 1 s        | 7 s        | 3 s        | 18 s       | 4 s         | 5.4 s   |
| 77      | 0 s        | 121 s      | 193 s      | 3 s        | 4 s        | 2 s        | 15 s       | 3 s        | 3 s        | 2 s         | 34.6 s  |

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


