# FPAA  - Leilão de Energia

**AVALIAÇÃO "TUDO JUNTO"**

Apresentação: 4/4 pontos

_Nota em Grupo:_
Relatório: 	 5/6

Pessoal, talvez vocês tenham colocado um esforço enorme (e provavelmente desnecessário) em detalhes sobre os algoritmos (por exemplo, trecho abaixo) e não colocaram os dados em um formato que facilite a observação dos resultados e conclusões.

    O algoritmo guloso foi escolhido devido à sua simplicidade e eficiência em encontrar uma solução aproximada em tempo razoável. Este método é particularmente eficaz quando há uma clara estratégia para ordenar e selecionar as empresas interessadas de forma a maximizar o lucro rapidamente.

Este texto (e os análogos a ele no relatório) não tem função alguma para nosso trabalho. Nenhum algoritmo foi "escolhido": era instrução que vocês implementassem as 4 modalidades. Todos sabemos que o guloso executa rapidamente e que, sendo este leilão uma variação da mochila, ele tem chance de ser eficiente em muitos casos. O meu pedido de relatório era para justificar as decisões específicas (ok, isto está feito corretamente depois).

Outro exemplo: mais a frente do relatório listar uma por uma solução de cada algoritmo (exmeplo abaixo) toma um espaço danado e não tem uso algum para a comparação entre elas. Um gráfico mostrando a progressão do tempo, ou um gráfico/tabela mostrando a comparação percentual do resultado, seria muito mais efetivo na visualização. 

    Resultado 9
    - Duração: 76000
    - Algoritmo Utilizado: GREEDY
    - Melhor Lucro: 4259.0
    - Quantidade Vendida: 990
    - Melhor Seleção:
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

Enfim, o trabalho está bem feito, mas talvez vocês possam pensar para o futuro em como priorizar visualização de resultados e o que está sendo pedido, em lugar de usar muito tempo e esforço em detalhes que não são necessários e que não contribuem para o objetivo proposto.  Vejam, por exemplo, que o Divisão e Conquista de vocês é apontado no relatório como mais de 3x mais lento que o Backtracking e tem pouca consideração sobre isso (provavelmente porque, do jeito que vocês implemetaram a combinação, a DC está praticamente sendo um Força Bruta - a substituição é feita individualmente, e não do resultado que havia sido encontrado).

Implementação: 9/10