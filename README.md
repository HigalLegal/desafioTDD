# Desafio de TDD da GFT

Desafio de TDD da GFT, onde pegamos alguns exercícios do desafio anterior e implementamos nele os testes unitários. Os projetos com os testes estão na pasta "projetos", enquanto na pasta "projeto-principal" se encontra o projeto que roda todos estes desafios dentro de uma única main.

**IMPORTANTE:** Caso der erro no código, ir em Build Path > Add libraries > User library > Next > new > colocar como nome "exerciciosEmJar" ou qualquer outro > Clicar em "OK" > Clicar nessa biblioteca feita > Add external JARs > Selecionar todos da pasta "JARS" > Clicar em Apply and close.

Lista de exercícios:

* Exercício 1: projetoVeiculo
* Exercício 2: lojaGFT
* Exercício 3: projetoRPG
* Exercício 7: exercicioFuncionarioGFT
* Exercício extra: pomboCorreio

### Enunciado do exercício extra:

Considere a seguinte situação. Um pombo correio leva mensagens entre os sites A e B, m as só quando o número de mensagens acumuladas chega a 20. Inicialmente, o pombo fica em A, esperando que existam 20 mensagens para carregar, e dormindo enquanto não houver. Quando as mensagens chegam a 20, o pombo deve levar e xatamente (nenhuma a mais nem a menos) 20 mensagens de A para B, e em segu ida voltar para A. Caso existam outras 20 mensagens, ele parte imediatament e; caso contrário, ele dorme de novo até que existam as 20 mensagens. As mensagens são escritas em um post-it pelos usuários ; cada usuário, quando tem uma mensagem pronta, cola sua mensagem na mochila do po mbo. Caso o pombo tenha partido, ele deve esperar o seu retorno p/ colar a mensagem na mochila. O vigésimo usuário deve acordar o pombo caso ele esteja dormindo. Cada usuário tem seu bloquinho inesgotável de post-it e continuamente prepara uma mensagem e a leva ao pombo. Usando semáforos, modele o processo pombo e o processo usuário, lembrando que existem muitos usuários e apenas um pombo. Identifique regiões críticas na vida do usuário e do pombo.

Link: <a href="https://dojopuzzles.com/problems/pombo-correio/">Clique aqui.</a>