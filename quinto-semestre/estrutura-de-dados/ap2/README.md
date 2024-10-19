# AP2 

## Grupo

- Ygor Bitencourt Evaldt
- Alessandra da Silveira

## Atividades

### 1 Implementação de Pilha e Fila com Lista Simplesmente Ligada

Você foi contratado para desenvolver um pequeno sistema de gerenciamento de pedidos para uma cafeteria. Esse sistema deverá organizar os pedidos dos clientes em duas estruturas de dados: uma Pilha e uma Fila, ambas implementadas utilizando listas simplesmente ligadas.

### Requisitos funcionais

[x] - O sistema deve poder adicionar um pedido <br>
[x] - O sistema deve poder atender um pedido e exibir o pedido que esta sendo atendido <br>
[x] - O sistema deve poder cancelar um pedido e exibir qual pedido está sendo cancelado <br>
[x] - O sistema deve poder restaurar um pedido e exibir qual pedido está sendo restaurado <br>
[x] - O sistema deve poder imprimir todos os pedidos pendentes <br>
[x] - O sistema deve poder imprimir todos os pedidos cancelados

### Regras de negócio

[x] - O pedido a ser atendido sempre é o pedido mais antigo da fila de pedidos pendentes <br>
[x] - O pedido a ser cancelado sempre é o pedido mais antigo da fila de pedidos pendentes <br>
[x] - O pedido a ser restaurado sempre é o último pedido que foi cancelado <br>
[x] - Pedidos restaurados devem ser posicionados no fim da fila de pedidos pendentes

### Requisitos não funcionais

[x] - Todo pedido deve ter id e descrição <br>
[x] - O Id do pedido deve ser do tipo UUID <br>
[x] - A descrição do pedido deve ter no máximo 100 caracteres <br>
[x] - Fila de pedidos pendentes <br>
    [x] - Método 'enqueue' para adicionar pedido no final da fila <br>
    [x] - Método 'dequeue' para remover pedido do início da fila (mais antigo) <br>
    [x] - Método 'printQueue' para imprimir todos os pedidos da fila <br>
[x] - Pilha de pedidos cancelados <br>
    [x] - Método 'push' para adicionar pedido cancelado no topo da pilha <br>
    [x] - Método 'pop' para remover o pedido cancelado mais recente <br>
    [x] - Método 'printStack' para imprimir todos os pedidos cancelados

<hr />

### 2 Implementação de Lista Duplamente Ligada para Gerenciamento de Biblioteca

### Requisitos funcionais

[] - Adicionar Livro no Início: Insira um novo livro no início da lista <br/>
[] - Adicionar Livro no Fim: Insira um novo livro no final da lista <br/>
[] - Remover Livro do Início: Remova o livro que está no início da lista <br/>
[] - Remover Livro do Fim: Remova o livro que está no final da lista <br/>
[] - Exibir livro que está sendo removido <br/>
[] - Pesquisar Livro por ID: Percorra a lista e encontre um livro específico pelo seu ID <br/>
[] - Exibir libro encontrado por id <br/>
[] - Imprimir Livros na Ordem Original: Exiba todos os livros da lista na ordem em que foram adicionados <br/>
[] - Imprimir Livros na Ordem Reversa: Exiba todos os livros da lista na ordem inversa 

### Requisitos não funcionais

[] - Lista Duplamente Ligada de Livros
[] - A lista deverá permitir a adição de livros tanto no início quanto no fim da lista <br/>
[] - Cada nó da lista de livros deve ter ponteiros para o nó anterior e próximo <br/>
[] - Todo livro deve ter id, título e autor
