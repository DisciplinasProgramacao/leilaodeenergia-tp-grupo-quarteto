### Relatório Técnico sobre Implementações e Comparação de Resultados

## I. Explicações sobre as Decisões Tomadas e o Funcionamento do Algoritmo Implementado

### Algoritmo Implementado: Backtracking

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

Para analisar a performance do algoritmo de backtracking, foram realizados testes com diferentes tamanhos de entrada, variando de 10 a 76 empresas interessadas. Abaixo está uma tabela que resume os tempos de execução e a média de execução para cada tamanho:

| Tamanho | Execução 1 | Execução 2 | Execução 3 | Execução 4 | Execução 5 | Execução 6 | Execução 7 | Execução 8 | Execução 9 | Execução 10 | Média  |
|---------|------------|------------|------------|------------|------------|------------|------------|------------|------------|-------------|--------|
| 10      | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s         | 0.0 s  |
| 74      | 65 s       | 4 s        | 20 s       | 6 s        | 25 s       | 0 s        | 0 s        | 6 s        | 11 s       | 17 s        | 15.4 s |
| 75      | 3 s        | 7 s        | 1 s        | 11 s       | 15 s       | 11 s       | 9 s        | 12 s       | 1 s        | 3 s         | 7.3 s  |
| 76      | 1 s        | 30 s       | 0 s        | 18 s       | 4 s        | 2 s        | 2 s        | 469 s      | 0 s        | 295 s       | 82.1 s |


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


## II. Explicações sobre as Decisões Tomadas e o Funcionamento do Algoritmo Implementado

### Algoritmo Implementado: Greedy1

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


## III. Explicações sobre as Decisões Tomadas e o Funcionamento do Algoritmo Implementado

### Algoritmo Implementado: Greedy2

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



## IV. Explicações sobre as Decisões Tomadas e o Funcionamento do Algoritmo Implementado

### Algoritmo Implementado: Divisão e Conquista

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

| Tamanho | Execução 1 | Execução 2 | Execução 3 | Execução 4 | Execução 5 | Execução 6 | Execução 7 | Execução 8 | Execução 9 | Execução 10 | Média  |
|---------|------------|------------|------------|------------|------------|------------|------------|------------|------------|-------------|--------|
| 10      | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s         | 0 s    |
| 70     | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s         | 0 s    |
| 71     | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s         | 0 s    |
| 72     | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s         | 0 s    |
| 73     | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s         | 0 s    |
| 74     | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s         | 0 s    |
| 75     | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s         | 0 s    |
| 76     | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s        | 0 s         | 0 s    |

Como citado anterioemente, da forma como o algoritmo foi implementado, se trona eficiente (frente aos testes realizados) pois irá fazer um quantidade de operações semelhante para leilões com valores de energia disponiveis iguais (Como o caso acima onde o valor de energia total considerado para todas as execuções foi de 1000), caso desconsiderarmos o "strem().filter(...).max(...)" e a "poda" realizada que limita a divisão do valores de energia disponivel quando ele está proxima da menor quantidade requerida dentre as empresas interessadas (ou sejan quando a proxima divisão será menor que a menor quantidade requerida dentre as empresas interessadas, rele retorna).
Podemos dizer então, que o tempo de execução do algoritmo almenta significamente com o almento da quantidade de energia disponível, e não com as empresas interessadas. Por exemplo, quanto o algoritmo foi exposto a uma quantidade de energia que se aproximava de 9 milhoe, ele teve o tempo consideravelmente almentado.

**Observações:**
- O algoritmo apresentou uma tempo de execução bem proximo, como pedemos ver no resultado, isso se deve ao que foi explicado anteriormente. Porem o algoritmo não se mostrou tão preciso quanto o backtraking, juntamente pela sua caracteristica de ao juntar os conjuntos ele optar por trocar o conjunto como um todo por outro item melhor, e não o item de seu conjunto.

**Análise dos Resultados:**

- **Desempenho em Tamanhos:**
 O algoritmo demostrou um tempo bem parecido idependente da quantidade de empresas interessadas justamente pela caracteristica já explicada no relatório.

- **Resultado:**
O algoritmo não se mostrou tão preciso quanto o backtraking, juntamente pela sua caracteristica de ao juntar os conjuntos ele optar por trocar o conjunto como um todo por outro item melhor, e não o item de seu conjunto, essa é uma caracteristica do próprio divisão e conquita, conforme pode ser observado nos slaides do professor ou em sala de aula.

### Conclusão

O algoritmo de Divisão e Conquista implementado é eficaz no tempo de resposta para o conjunto estudado do problema de seleção de empresas interessadas. No entanto, a precisão no resultado se torna um desafio devido as suas caracteristicas de troca. Em relação ao tempo de execução, sua execução varia quando almentamos a quantidade de enegia disponível, devido a abordagem da recursividade.

## V. Explicações sobre as Decisões Tomadas e o Funcionamento do Algoritmo Implementado

### Algoritmo Implementado: Programação Dinâmica

O método de Programação Dinâmica desenvolvido para abordar o desafio da seleção de empresas interessadas, utiliza a estratégia de construir uma tabela com as informação das empresas interessadas vs quantidade Disponível para maximizar o lucru obtido.
Para o problema apresentado, a solução implementada monta uma tabela onde as linhas são as empresas interessadas e as colunas são a quantidade de energia disponível para aquela coluna, e as células é o lucro obtido (dado a relação empresa vs valor disponível na coluna), durante a inserção das empresas interessadas. Para cadas empresa existe ele valida se a proposta dessa empresa é melhor que a empresa anterio para aquela quantidade disponível, se for ela é inserida, caso não for é mantido a empresa da linha anterior. Após a montagem da tabela o algoritmo percorre a tabela partindo da ultima posição para buscar as empresas inseridas.

**Decisões Tomadas:**

1. **Escolha do Algoritmo:**
   O algoritmo de Programação Dinâmica foi escolhido devido à sua capacidade de montar uma tabela com todos os resultado possivel, isso permite que o objetivo de encontrar a melhor seleção de empresas que comprem os produtos de uma empresa vendedora seja mais efetiva para maximizar o lucro sem ultrapassar a quantidade disponível.

2. **Estrutura do Algoritmo:**
   O algoritmo realiza doi lopes um dentro do outro para montar a tabela, um para percorrer as empresas, e outra para passar pelas quantidades disponíveis que vai de 0 até a quantidade disponível. dessa forma são feita as comparações necessárias para informar se a empresa irá entrar ou não (Essa comparação consiste em comparar o valor que irá entrar + a celula na porsição (coluna atual - a linha atual) da linha anterio), esse valor é comparado co o da coluna atual e linha anterior, caso, seja melhor ele entra, caso não persiste o anterior. Após a montagem da tabela, é feito um loop para percorrer a tabela partindo do final, para buscar as empresas inseridas.

3. **Condições de Parada:**
   O algoritmo para quando a tabela é preenchida totalmente, já que o resultado fica na ultima celula da tabela.

**Funcionamento do Algoritmo:**

1. **Execução do Algoritmo:**
   - O algoritmo inicializa a tabela com o tamanho da lista de empresas de interessados mais 1 na linha e o valor disponível mais um na coluna, partindo do principel que a tabela vá de 1 até n e não de 0 até n-1; 
   - Para cada empresa ele compara se ela pode ser inserida ou não, caso sim ele altera o valor na celula, caso não ele insere o valor da linha anterior.
   - Após a criação da tabela é feito um loop para encontrar as empresas interessadas inseridas.

3. **Resultado:**
   - O resultado contém a melhor seleção de empresas, o melhor lucro, a quantidade vendida e o algoritmo utilizado.

#### II. Comparação de Resultados Obtidos pelas Implementações

**Tempo de Execução e Qualidade do Resultado:**

Para analisar a performance do algoritmo de Programação dinâmica, foram realizados testes com o conjunto T (76) encontrado no Backtraking, e incrementando de T em T até 10 T . 
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



**Observações:**
- O algoritmo apresentou uma tempo de execução bem proximoa a zero com os valores testados, como pedemos ver no resultado, e seu algoritmo grante a precisão no resultado para maximizar o lucro do nosso leilão, por isso, frente aos testes realizados, pode ser uma ótima opção para maximizar o lucro do leilão de energia.

**Análise dos Resultados:**

- **Desempenho em Tamanhos:**
- para os testes realizados o algoritmo apresentou um tempo bem proximo de zero, melhorando um problema que apareceu no backtraking por exemplo.

- **Resultado:**
O algoritmo apresentou resultado coerente, bem próximo do ótimo, fazendo um comparativos seu resultado se assemelha aos resultados do backtraking porem em um tempo muito menos de execução.

### Conclusão

O algoritmo de Programação Dinâmica implementado é eficaz no tempo de resposta e tem alta precisão no seu resultado (dado o teste ralizado), por isso, é um bom algoritimo a ser utilizado, porém a um ponto a se ressaltar, da forma como foi implementado nesse trabalho, podemos dizer que é um algoritmo exponêncial (n^2+n), dessa forma deve-se ter precauções frente a entrada de dados muito grande, pois o algoritmo pode começar a escalornar o tempo de resposta.

#### Teste Realizado 

Os testes abaixo foram realizados com todos algoritmos selecionados, devido ao banco de dados utilizado não conseguitmos realizar executar a classe de testes com os mesmos dados para as 10 execuções, porêm abaixo comtém um exemplo de execução com os mesmos dados para todos os algoritmos abordados. 

### Divisão e Conquista

**Resultado 1**

- **Duração:** 86753600
- **Algoritmo Utilizado:** DIVISAOECONQUISTA
- **Melhor Lucro:** 5314.0
- **Quantidade Vendida:** 970
- **Melhor Seleção:**
    - Empresa L41
    - Empresa L72
    - Empresa L6
    - Empresa L4
    - Empresa L47
    - Empresa L40
    - Empresa L49
    - Empresa L14
    - Empresa L61
    - Empresa L24
    - Empresa L16
    - Empresa L15
    - Empresa L54
    - Empresa L44

- **Resultado 2**

- **Duração:** 13027600
- **Algoritmo Utilizado:** DIVISAOECONQUISTA
- **Melhor Lucro:** 7207.0
- **Quantidade Vendida:** 1000
- **Melhor Seleção:**
    - Empresa L4
    - Empresa L56
    - Empresa L70
    - Empresa L48
    - Empresa L2
    - Empresa L5
    - Empresa L57
    - Empresa L64
    - Empresa L22
    - Empresa L31
    - Empresa L45
    - Empresa L73
    - Empresa L25
    - Empresa L42
    - Empresa L65
    - Empresa L46
    - Empresa L63
    - Empresa L58

- **Resultado 3**

- **Duração:** 8210500
- **Algoritmo Utilizado:** DIVISAOECONQUISTA
- **Melhor Lucro:** 4184.0
- **Quantidade Vendida:** 920
- **Melhor Seleção:**
    - Empresa L26
    - Empresa L30
    - Empresa L1
    - Empresa L4
    - Empresa L32
    - Empresa L5
    - Empresa L13
    - Empresa L14
    - Empresa L28
    - Empresa L38
    - Empresa L19
    - Empresa L50
    - Empresa L6

- **Resultado 4**

- **Duração:** 8351400
- **Algoritmo Utilizado:** DIVISAOECONQUISTA
- **Melhor Lucro:** 4477.0
- **Quantidade Vendida:** 900
- **Melhor Seleção:**
    - Empresa L11
    - Empresa L30
    - Empresa L71
    - Empresa L1
    - Empresa L6
    - Empresa L72
    - Empresa L74
    - Empresa L47
    - Empresa L48
    - Empresa L34
    - Empresa L26
    - Empresa L38

- **Resultado 5**

- **Duração:** 5564300
- **Algoritmo Utilizado:** DIVISAOECONQUISTA
- **Melhor Lucro:** 3891.0
- **Quantidade Vendida:** 920
- **Melhor Seleção:**
    - Empresa L41
    - Empresa L26
    - Empresa L50
    - Empresa L36
    - Empresa L31
    - Empresa L62
    - Empresa L38
    - Empresa L75
    - Empresa L66
    - Empresa L43
    - Empresa L67
    - Empresa L6

- **Resultado 6**

- **Duração:** 5293700
- **Algoritmo Utilizado:** DIVISAOECONQUISTA
- **Melhor Lucro:** 5614.0
- **Quantidade Vendida:** 980
- **Melhor Seleção:**
    - Empresa L26
    - Empresa L41
    - Empresa L56
    - Empresa L40
    - Empresa L45
    - Empresa L39
    - Empresa L10
    - Empresa L27
    - Empresa L42
    - Empresa L55
    - Empresa L61
    - Empresa L1
    - Empresa L60
    - Empresa L57
    - Empresa L7
    - Empresa L12
    - Empresa L28

- **Resultado 7**

- **Duração:** 3906900
- **Algoritmo Utilizado:** DIVISAOECONQUISTA
- **Melhor Lucro:** 6059.0
- **Quantidade Vendida:** 960
- **Melhor Seleção:**
    - Empresa L47
    - Empresa L19
    - Empresa L73
    - Empresa L75
    - Empresa L76
    - Empresa L26
    - Empresa L64
    - Empresa L20
    - Empresa L21
    - Empresa L72
    - Empresa L39
    - Empresa L55
    - Empresa L42
    - Empresa L66
    - Empresa L44

- **Resultado 8**

- **Duração:** 4417600
- **Algoritmo Utilizado:** DIVISAOECONQUISTA
- **Melhor Lucro:** 4710.0
- **Quantidade Vendida:** 930
- **Melhor Seleção:**
    - Empresa L1
    - Empresa L56
    - Empresa L15
    - Empresa L58
    - Empresa L25
    - Empresa L74
    - Empresa L75
    - Empresa L3
    - Empresa L2
    - Empresa L30
    - Empresa L33
    - Empresa L35
    - Empresa L72

- **Resultado 9**

- **Duração:** 3800700
- **Algoritmo Utilizado:** DIVISAOECONQUISTA
- **Melhor Lucro:** 4155.0
- **Quantidade Vendida:** 960
- **Melhor Seleção:**
    - Empresa L14
    - Empresa L21
    - Empresa L73
    - Empresa L29
    - Empresa L66
    - Empresa L17
    - Empresa L15
    - Empresa L4
    - Empresa L60
    - Empresa L47

- **Resultado 10**

- **Duração:** 4646400
- **Algoritmo Utilizado:** DIVISAOECONQUISTA
- **Melhor Lucro:** 5597.0
- **Quantidade Vendida:** 990
- **Melhor Seleção:**
    - Empresa L29
    - Empresa L51
    - Empresa L75
    - Empresa L1
    - Empresa L3
    - Empresa L45
    - Empresa L12
    - Empresa L17
    - Empresa L39
    - Empresa L65
    - Empresa L43
    - Empresa L50
    - Empresa L64
    - Empresa L42
    - Empresa L49

### Greedy 

**Resultado 1**

- **Duração**: 1089900
- **Algoritmo Utilizado:** GREEDY
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

- **Duração**: 152600
- **Algoritmo Utilizado:** GREEDY
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

- **Duração**: 168100
- **Algoritmo Utilizado:** GREEDY
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

- **Duração**: 65700
- **Algoritmo Utilizado:** GREEDY
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

- **Duração**: 68000
- **Algoritmo Utilizado:** GREEDY
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

- **Duração**: 95600
- **Algoritmo Utilizado:** GREEDY
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

- **Duração**: 74900
- **Algoritmo Utilizado:** GREEDY
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

- **Duração**: 120400
- **Algoritmo Utilizado:** GREEDY
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

- **Duração**: 76000
- **Algoritmo Utilizado:** GREEDY
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

- **Duração**: 85600
- **Algoritmo Utilizado:** GREEDY
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

### Greedy 1


**Resultado 1**

- **Duração:** 1733500
- **Algoritmo Utilizado:** GREEDY1
- **Melhor Lucro:** 2849.0
- **Quantidade Vendida:** 1000
- **Melhor Seleção:**
    - Empresa L35
    - Empresa L45
    - Empresa L49
    - Empresa L39
    - Empresa L24

**Resultado 2**

- **Duração:** 191400
- **Algoritmo Utilizado:** GREEDY1
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

- **Duração:** 152200
- **Algoritmo Utilizado:** GREEDY1
- **Melhor Lucro:** 2021.0
- **Quantidade Vendida:** 1000
- **Melhor Seleção:**
    - Empresa L71
    - Empresa L39
    - Empresa L26
    - Empresa L30

**Resultado 4**

- **Duração:** 122900
- **Algoritmo Utilizado:** GREEDY1
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

- **Duração:** 81900
- **Algoritmo Utilizado:** GREEDY1
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

- **Duração:** 101900
- **Algoritmo Utilizado:** GREEDY1
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

- **Duração:** 80900
- **Algoritmo Utilizado:** GREEDY1
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

- **Duração:** 137800
- **Algoritmo Utilizado:** GREEDY1
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

- **Duração:** 84500
- **Algoritmo Utilizado:** GREEDY1
- **Melhor Lucro:** 2704.0
- **Quantidade Vendida:** 980
- **Melhor Seleção:**
    - Empresa L33
    - Empresa L60
    - Empresa L21
    - Empresa L73
    - Empresa L66

**Resultado 10**

- **Duração:** 83300
- **Algoritmo Utilizado:** GREEDY1
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

### Programação Dinâmica

**Resultado 1**

- **Duração:** 4087100
- **Algoritmo Utilizado:** PROGRAMACAODINAMICA
- **Melhor Lucro:** 5576.0
- **Quantidade Vendida:** 990
- **Melhor Seleção:**
   - Empresa L75
   - Empresa L72
   - Empresa L61
   - Empresa L49
   - Empresa L47
   - Empresa L41
   - Empresa L40
   - Empresa L37
   - Empresa L26
   - Empresa L24
   - Empresa L15
   - Empresa L14
   - Empresa L4

**Resultado 2**

- **Duração:** 1010200
- **Algoritmo Utilizado:** PROGRAMACAODINAMICA
- **Melhor Lucro:** 7504.0
- **Quantidade Vendida:** 990
- **Melhor Seleção:**
   - Empresa L70
   - Empresa L67
   - Empresa L65
   - Empresa L64
   - Empresa L63
   - Empresa L57
   - Empresa L56
   - Empresa L48
   - Empresa L45
   - Empresa L31
   - Empresa L24
   - Empresa L22
   - Empresa L13
   - Empresa L5
   - Empresa L4
   - Empresa L2

**Resultado 3**

- **Duração:** 399500
- **Algoritmo Utilizado:** PROGRAMACAODINAMICA
- **Melhor Lucro:** 5290.0
- **Quantidade Vendida:** 1000
- **Melhor Seleção:**
   - Empresa L64
   - Empresa L58
   - Empresa L48
   - Empresa L40
   - Empresa L32
   - Empresa L30
   - Empresa L28
   - Empresa L26
   - Empresa L19
   - Empresa L13
   - Empresa L5
   - Empresa L4
   - Empresa L1

**Resultado 4**

- **Duração:** 146500
- **Algoritmo Utilizado:** PROGRAMACAODINAMICA
- **Melhor Lucro:** 5108.0
- **Quantidade Vendida:** 1000
- **Melhor Seleção:**
   - Empresa L74
   - Empresa L72
   - Empresa L71
   - Empresa L70
   - Empresa L48
   - Empresa L47
   - Empresa L42
   - Empresa L30
   - Empresa L26
   - Empresa L20
   - Empresa L11
   - Empresa L6
   - Empresa L1

**Resultado 5**

- **Duração:** 135400
- **Algoritmo Utilizado:** PROGRAMACAODINAMICA
- **Melhor Lucro:** 4112.0
- **Quantidade Vendida:** 980
- **Melhor Seleção:**
   - Empresa L75
   - Empresa L67
   - Empresa L66
   - Empresa L62
   - Empresa L50
   - Empresa L43
   - Empresa L41
   - Empresa L38
   - Empresa L36
   - Empresa L26
   - Empresa L6
   - Empresa L4

**Resultado 6**

- **Duração:** 136000
- **Algoritmo Utilizado:** PROGRAMACAODINAMICA
- **Melhor Lucro:** 5724.0
- **Quantidade Vendida:** 1000
- **Melhor Seleção:**
   - Empresa L61
   - Empresa L60
   - Empresa L57
   - Empresa L56
   - Empresa L55
   - Empresa L51
   - Empresa L46
   - Empresa L45
   - Empresa L42
   - Empresa L41
   - Empresa L40
   - Empresa L39
   - Empresa L28
   - Empresa L27
   - Empresa L26
   - Empresa L10
   - Empresa L1

**Resultado 7**

- **Duração:** 183600
- **Algoritmo Utilizado:** PROGRAMACAODINAMICA
- **Melhor Lucro:** 6214.0
- **Quantidade Vendida:** 1000
- **Melhor Seleção:**
   - Empresa L76
   - Empresa L75
   - Empresa L73
   - Empresa L72
   - Empresa L66
   - Empresa L64
   - Empresa L47
   - Empresa L44
   - Empresa L42
   - Empresa L39
   - Empresa L29
   - Empresa L26
   - Empresa L21
   - Empresa L20
   - Empresa L19

**Resultado 8**

- **Duração:** 2986100
- **Algoritmo Utilizado:** PROGRAMACAODINAMICA
- **Melhor Lucro:** 5030.0
- **Quantidade Vendida:** 980
- **Melhor Seleção:**
   - Empresa L75
   - Empresa L74
   - Empresa L72
   - Empresa L58
   - Empresa L56
   - Empresa L51
   - Empresa L35
   - Empresa L30
   - Empresa L25
   - Empresa L15
   - Empresa L12
   - Empresa L3
   - Empresa L2
   - Empresa L1

**Resultado 9**

- **Duração:** 889600
- **Algoritmo Utilizado:** PROGRAMACAODINAMICA
- **Melhor Lucro:** 4259.0
- **Quantidade Vendida:** 990
- **Melhor Seleção:**
   - Empresa L73
   - Empresa L69
   - Empresa L66
   - Empresa L60
   - Empresa L47
   - Empresa L29
   - Empresa L21
   - Empresa L17
   - Empresa L14
   - Empresa L4

R**esultado 10**

- **Duração:** 825100
- **Algoritmo Utilizado:** PROGRAMACAODINAMICA
- **Melhor Lucro:** 5969.0
- **Quantidade Vendida:** 1000
- **Melhor Seleção:**
   - Empresa L75
   - Empresa L70
   - Empresa L65
   - Empresa L64
   - Empresa L51
   - Empresa L50
   - Empresa L45
   - Empresa L43
   - Empresa L42
   - Empresa L29
   - Empresa L12
   - Empresa L3
   - Empresa L2
   - Empresa L1

### Backtraking

**Resultado 1**

- **Duração:** 18640300500 nanosegundos
- **Algoritmo Utilizado:** BACKTRAKING
- **Melhor Lucro:** 5576.0
- **Quantidade Vendida:** 990
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
   - Empresa L40

**Resultado 2**

- **Duração:** 54279555200 nanosegundos
- **Algoritmo Utilizado:** BACKTRAKING
- **Melhor Lucro:** 7504.0
- **Quantidade Vendida:** 990
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
   - Empresa L67
   - Empresa L24

**Resultado 3**

- **Duração:** 4403919900 nanosegundos
- **Algoritmo Utilizado:** BACKTRAKING
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

- **Duração:** 1367361500 nanosegundos
- **Algoritmo Utilizado:** BACKTRAKING
- **Melhor Lucro:** 5108.0
- **Quantidade Vendida:** 1000
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
   - Empresa L20

**Resultado 5**

- **Duração:** 498291500 nanosegundos
- **Algoritmo Utilizado:** BACKTRAKING
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

- **Duração:** 54483006800 nanosegundos
- **Algoritmo Utilizado:** BACKTRAKING
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

- **Duração:** 2572011300 nanosegundos
- **Algoritmo Utilizado:** BACKTRAKING
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

- **Duração:** 4804577900 nanosegundos
- **Algoritmo Utilizado:** BACKTRAKING
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

- **Duração:** 119876300 nanosegundos
- **Algoritmo Utilizado:** BACKTRAKING
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

- **Duração:** 20075520100 nanosegundos
- **Algoritmo Utilizado:** BACKTRAKING
- **Melhor Lucro:** 5969.0
- **Quantidade Vendida:** 1000
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
   - Empresa L42
   - Empresa L70

## VI. Conclusão dos Resultados Encontrados nos Testes Acima

### Análise dos resultados obtidos

 - Os resultados foram obtidos utilizando quatro algoritmos diferentes para determinar a melhor seleção de empresas com base no lucro e na quantidade vendida. Abaixo está uma análise comparativa dos algoritmos:

    **Análise Comparativa**

    **Melhor Lucro**

     - Programação Dinâmica: 7504.0
     - Divisão e Conquista: 7207.0
     - Backtracking: 7312.0
     - Greedy: 7464.0
     - Greedy1: 4536.0

    **Melhor Tempo de Execução:**

     - Greedy1: 65.7 ms
     - Greedy: 152.6 ms
     - Programação Dinâmica: 135.4 ms
     - Backtracking: 1.12 s
     - Divisão e Conquista: 3.90 s

    **Quantidade Vendida Consistentemente Alta**

     - Todos os algoritmos alcançam 1000 unidades vendidas em pelo menos um dos testes.

    **Considerações:**

     - Melhor Algoritmo: A Programação Dinâmica apresentou os melhores lucros no menor tempo, sendo o algoritmo mais eficiente no geral.
     - Eficiência de Tempo: Os algoritmos Greedy e Greedy1 são extremamente rápidos, mas não necessariamente alcançam os melhores lucros comparados à Programação Dinâmica e Backtracking.
     - Backtracking: Apresenta bons lucros, mas é mais lento em comparação aos outros métodos, o que pode ser um problema para grandes conjuntos de dados.
    

    **Análise Detalhada:**

     **Algoritmo de Divisão e Conquista:**

     - Vantagens: Obteve um lucro razoavelmente bom em várias execuções, com um tempo de execução médio aceitável.
     - Desvantagens: Variabilidade no lucro e tempo de execução, com alguns resultados significativamente mais lentos.

     **Algoritmo Greedy:**

     - Vantagens: Resultados rápidos e consistentes. Alcance de lucros altos em execuções diversas.
     - Desvantagens: Pode não encontrar a solução ótima em todos os casos devido à sua natureza heurística.

     **Algoritmo Greedy 1:**

     - Vantagens: Tempo de execução rápido.
     - Desvantagens: Lucros consistentemente mais baixos em comparação com os outros algoritmos.

     **Algoritmo de Programação Dinâmica:**

      - Vantagens: Maior lucro obtido, com um tempo de execução aceitável para a maioria dos casos.
      - Desvantagens: Ainda mais lento que o Greedy, mas proporciona uma solução mais próxima do ótimo.

     **Algoritmo de Backtracking:**

      - Vantagens: Capaz de encontrar soluções muito boas, às vezes alcançando lucros altos e a solução ótima.
      - Desvantagens: Tempo de execução mais longo, especialmente para grandes conjuntos de dados, o que pode ser impraticável em aplicações com restrições de tempo.
            
    **Recomendação**

      - Para situações em que o lucro máximo é a prioridade e o tempo de execução não é um grande problema, recomenda-se o uso do algoritmo de Programação Dinâmica. Entretanto, para aplicações onde a velocidade é crítica e um bom lucro é aceitável, o algoritmo Greedy ou Divisão e Conquista é a melhor escolha.

    **Conclusão:**

     - Dependendo da prioridade (tempo vs. lucro), a escolha do algoritmo pode variar. Para maximizar o lucro em um tempo aceitável, a Programação Dinâmica é a melhor escolha. Para soluções rápidas com lucros razoáveis, os algoritmos Greedy ou Divisão e Conquista ( obtendo um resultado intermediário )  são mais adequados.

### Comparativo de Complexidade

- *Backtracking*:
  - *Complexidade*: Exponencial. É o mais custoso em termos de tempo de execução, especialmente para conjuntos maiores de dados devido à sua natureza recursiva e à exploração completa de todas as combinações possíveis.

- *Guloso 1 (GREEDYUNITARIO)*:
  - *Complexidade*: O(n log n) devido à necessidade de ordenar os elementos antes de aplicar a heurística gulosa.

- *Guloso 2 (GREEDYVALORDESC)*:
  - *Complexidade*: O(n log n) similar ao GREEDYUNITARIO, com a ordenação sendo o principal fator de complexidade.

- *Divisão e Conquista*:
  - *Complexidade*: O(n log n) a O(n^2), dependendo da implementação e do problema específico. Geralmente, esta abordagem tem um desempenho intermediário.

- *Programação Dinâmica*:
  - *Complexidade*: O(n * W), onde n é o número de itens e W é a capacidade do "knapsack". É mais eficiente que o backtracking em muitos casos, especialmente para grandes conjuntos de dados, mas pode ser menos eficiente que os métodos gulosos para pequenas entradas.

### Análise de Tempo de Execução

- *Backtracking*:
  - *Baixa Quantidade de Dados*: Pode ser aceitável, mas ainda assim tende a ser mais lento.
  - *Alta Quantidade de Dados*: Extremamente lento e impraticável devido à explosão combinatória.
  - *Qualidade dos ResultadosDTO*: Alta precisão, explorando todas as possibilidades para encontrar a solução ótima.

- *Guloso 1 (GREEDYUNITARIO)* e *Guloso 2 (GREEDYVALORDESC)*:
  - *Baixa Quantidade de Dados*: Rápidos e eficientes, fornecendo soluções rápidas.
  - *Alta Quantidade de Dados*: Continuam sendo rápidos, mas a precisão pode diminuir se as heurísticas não forem adequadas.
  - *Qualidade dos ResultadosDTO*: Variável, pode não encontrar a solução ótima, mas eficiente em termos de tempo.

- *Divisão e Conquista*:
  - *Baixa Quantidade de Dados*: Desempenho aceitável, mas geralmente não tão rápido quanto os métodos gulosos.
  - *Alta Quantidade de Dados*: Pode ser mais lento que os métodos gulosos e a programação dinâmica, mas ainda viável.
  - *Qualidade dos ResultadosDTO*: Boa precisão, mas não garantida para ser ótima.

- *Programação Dinâmica*:
  - *Baixa Quantidade de Dados*: Rápido e eficiente, similar aos métodos gulosos.
  - *Alta Quantidade de Dados*: Permanece eficiente em termos de tempo, lidando bem com grandes entradas.
  - *Qualidade dos ResultadosDTO*: Alta precisão, frequentemente encontra a solução ótima, equilibrando tempo e qualidade.

### Resultados Baseados na Execução com 76 Empresas

- *Backtracking*:
  - *Tempo*: Muito lento, pode levar uma quantidade impraticável de tempo.
  - *Quantidade Vendida x Lucro*: Precisão alta, melhor seleção encontrada.

- *Guloso 1 e Guloso 2*:
  - *Tempo*: Muito rápidos, eficientes em termos de tempo.
  - *Quantidade Vendida x Lucro*: Menor precisão em comparação com backtracking e programação dinâmica, soluções subótimas possíveis.

- *Divisão e Conquista*:
  - *Tempo*: Intermediário, pode variar.
  - *Quantidade Vendida x Lucro*: Boas soluções, mas não garantido ótimo.

- *Programação Dinâmica*:
  - *Tempo*: Bom desempenho, eficiente.
  - *Quantidade Vendida x Lucro*: Alta precisão, frequentemente encontra a solução ótima.

### Conclusão Final: Melhor Algoritmo e Por Quê

Para *baixa quantidade de dados, os métodos **gulosos* são preferíveis devido à sua rapidez e eficiência. Eles fornecem soluções rapidamente, apesar de não garantirem a solução ótima.

Para *alta quantidade de dados, a **programação dinâmica* é a melhor escolha. Ela oferece um bom equilíbrio entre tempo de execução e qualidade dos resultados, frequentemente encontrando a solução ótima.

O *backtracking* é mais preciso, mas impraticável para grandes conjuntos de dados devido ao seu alto custo computacional. A *divisão e conquista* pode ser uma escolha intermediária, mas geralmente é menos eficiente que a programação dinâmica.

*Custo-benefício: **Programação Dinâmica* é a solução mais balanceada, oferecendo boa precisão e eficiência para a maioria dos casos, especialmente com grandes quantidades de dados.
