# Criando API REST com Node.js

## Conteúdo
- [Estrutura da aplicação](#estrutura-da-aplicação)
- [Banco de dados](#banco-de-dados)
- [Rotas e HTTP](#rotas-e-http)

## Estrutura da aplicação

- O Fastify é um microframework web rápido e minimalista para Node.js.
- O TypeScript,  apesar de antes ser considerado apenas um superset, com a presença de runtimes (Deno e Bun) que executam o TypeScript nativamente, ele pode ser considerado uma linguagem.
- A vantagem de se utilizar TypeScript ao invés de JavaScript é que o TypeScript fornece tipagem estática, melhorando a qualidade do código e facilitando a manutenção.
- Uma ‘interface’ é TypeScript é um conjunto de tipos que especificam as propriedades e métodos que um objeto deve ter.
- Fastify tem suporte nativo ao TypeScript

## Banco de dados

- As principais vantagens de usar um query builder em vez de um driver nativo no Node.js são que um query builder é mais fácil de usar e oferece uma API mais intuitiva e facilidade para trocar bancos de dados.

- A troca de banco de dados quando a aplicação usa query builders depende da documentação e da compatibilidade do query builder com outros bancos de dados.

- Migrations são scripts que modificam o esquema do banco de dados

- Comando do Knex para criar uma nova migration:
    - `knex migrate:make`
- Comando do Knex para rodar todas as migrations pendentes:
    - `knex migrate:latest`
- Comando do Knex para reverter a última migration aplicada:
    - `knex migrate:rollback`
- Método do Knex para realizar uma query de inserção em uma tabela:
    - `knex...insert()`
- Método do Knex para realizar uma query de seleção de todos os registros de uma tabela:
    - `knex...select()`

- Variáveis de ambiente são variáveis que só existem em determinado ambiente, como o desenvolvimento ou produção

- É possível acessar uma variável ambiente em um programa escrito em JavaScript usando a variável global process.env
    - Para ter acesso ao conteúdo de proccess.env, utilize as flags `—env-file .env` nos scripts de execução do app em `package.json`
    
- O principal objetivo da biblioteca zod é validar tipos e formatos de dados

## Rotas e HTTP
- Requisítos funcionais são características do sistema que devem ser atendidas para atingir seus objetivos;

- No Fastify, configuramos rotas com um path em comum utilizando o método `register` para registrar um plugin que contém todas as rotas com o mesmo path;
- Podemos acessar os cookies enviados por um cliente no Fastify utilizando `request.cookies`;
- É possível configurar opções para os Cookies, como o tempo de expiração, ao escrever um cookie no Fastify passando um objeto com as opções como terceiro parâmetro da função;
- No Fastify, `preHendler` é uma função que é executada antes de uma rota;
- Os contextos dentro de um plugin no Fastify são isolados entre eles;
- No Fastify, os Hooks são funções que são executadas de acordo ao hook configurado;

- No TypeScript `declare module` server para declarar módulos personalizados;

- É possível criar tipos personalizados para representar tabelas e colunas no TypeScript escrevendo manualmente as definições de tipos.

### Testes automatizados

- A pirâmide de testes é uma representação gráfica das quantidades de diferentes tipos de testes na aplicação;
- Testes unitários são feitos para testar uma pequena unidade de código de forma isolada;
- Testes de integração são feitos para testar a integração entre diferentes módulos da aplicação;
- Testes end-to-end(e2e) são feitos para testar o sistema completo de uma só vez, simulando a interação do usuário;
- O método `beforeAll` é executado uma única vez antes de todos os testes em um bloco de teste, ele também serve para preparar o ambiente antes da execução dos testes dentro do bloco de teste;
- O método `afterAll` é executado uma única vez depois de todos os testes em um bloco de teste;
- O método `beforeEach` é executado antes de cada teste em um bloco de teste;
- O método `afterEach` é executado depois de cada teste em um bloco de teste;
- No contexto de testes e2e, o supertest tem como objetivo realizar requisições HTTP para uma aplicação e validar suas respostas;
- É possível fazer verificações no corpo da resposta de uma requisição HTTP feita com o supertest utilizando o método `.expect()`;
- É possível enviar dados em uma requisição HTTP feita com o supertest utilizando o método `.send()`;
- O método `.describe()` cria uma categoria de testes para que eles sejam agrupados.


