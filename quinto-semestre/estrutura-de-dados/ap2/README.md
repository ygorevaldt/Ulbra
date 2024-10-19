# AP2 

## Grupo

- Ygor Bitencourt Evaldt
- Alessandra da Silveira

## Atividades

### 1

Você foi contratado para desenvolver um pequeno sistema de gerenciamento de pedidos para uma cafeteria. Esse sistema deverá organizar os pedidos dos clientes em duas estruturas de dados: uma Pilha e uma Fila, ambas implementadas utilizando listas simplesmente ligadas.

### Requisitos funcionais

[x] - O sistema deve poder adicionar um pedido <br>
[x] - O sistema deve poder atender um pedido e exibir o pedido que esta sendo atendido <br>
[x] - O sistema deve poder cancelar um pedido e exibir qual pedido está sendo cancelado <br>
[] - O sistema deve poder restaurar um pedido e exibir qual pedido está sendo restaurado <br>
[x] - O sistema deve poder imprimir todos os pedidos pendentes <br>
[x] - O sistema deve poder imprimir todos os pedidos cancelados <br>

### Regras de negócio

[x] - O pedido a ser atendido sempre é o pedido mais antigo da fila de pedidos pendentes <br>
[] - Pedidos restaurados devem ser posicionados no fim da fila de pedidos pendentes <br>

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
    [x] - Método 'pop(id)' para remover o pedido cancelado por id <br>
    [x] - Método 'printStack' para imprimir todos os pedidos cancelados <br>
