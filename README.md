# Lista de Personagens

Descrição: Aplicativo base para a realização dos exercícios avaliativos do módulo MB-KT-007.

Exercícios Avaliativos:

### Exercício 01: SOLID 

Incorporar todos os princípios SOLID no projeto inicial, em códigos existentes ou criados por vocês 
(qualquer tipo de código que faça sentido para o app será válido), 
documentando cada princípio aplicado da seguinte forma:

- Qual o princípio e suas características?
- Por quê foi utilizado?
- Quais os ganhos essa implementação irá trazer caso o app cresça?

Obs: a documentação deverá ser feita através de comentários no próprio código, acima da implementação.

### Exercício 02: Injeção de Dependências 

Escolher uma biblioteca de injeção de dependências automática, Koin ou Hilt, para aplicar em todo o projeto.

Será necessário desenvolver o fluxo completo de login do usuário baseado no fluxograma abaixo (como feito nos exemplos da aula):

![image](https://user-images.githubusercontent.com/44252209/232302589-6a83c53e-2fb7-402b-a4f2-dc6d17aa4025.png)

Esse fluxo deverá ter todas as dependências sendo injetadas e controladas automaticamente.

Obs: se atente a possíveis instâncias únicas (singletons) e a necessidade de se informar sobre a implementação de interfaces serem injetadas (binds) na sua aplicação.

### Exercício 03: Padrões de Design 

Escolha 06 padrões de design, 02 de cada tipo (criacionais, estruturais e comportamentais), para implementar em seu projeto.

Explique as vantagens que cada padrão irá trazer para o seu projeto e simule casos reais de uso que poderiam aparecer no seu aplicativo (outros tipos de personagens possam ser listados, abranger cadastro e reset de senha no fluxo de login, armazenamento de dados do perfil do usuário, integração com biblioteca analítica de dados, mostrar detalhes de personagens, etc.).

- Criacionais: responsáveis criar objetos
  - Singleton
  - Builder
  - Prototype
  - Factory Method
  - Abstract Factory
- Estruturais: adicionam comportamentos em objetos existentes
  - Adapter
  - Decorator
  - Facade
- Comportamentais: definem como diferentes objetos se comunicam e trocam informações entre si
  - Iterator
  - Observer
  - State
  
Obs: os padrões listados como opção de escolha foram aqueles apresentados em aula. Se preferir, poderá aplicar também qualquer um dos outros [23 padrões disponíveis](https://miro.medium.com/v2/resize:fit:1356/1*X-oALeV_4OjExuhsHIv2Xw.png).

<p align="center">
  <img src="https://miro.medium.com/v2/resize:fit:1356/1*X-oALeV_4OjExuhsHIv2Xw.png" />
</p>
