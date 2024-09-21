# Semipresencial

Implementar uma classe Java que represente a estrutura de dados Vetor para armazenar objetos do tipo Cliente. A classe deve permitir a criação de um vetor de tamanho fixo, definido no momento da instanciação, e fornecer métodos para a manipulação dos elementos armazenados. Este exercício é uma adaptação da classe Vetor utilizada anteriormente para armazenar Strings.

## Classe Cliente:
Atributos: nome, telefone, email.
Encapsulamento: Mantenha os atributos privados e forneça métodos getters e setters para acessá-los e modificá-los.
Método toString: Sobrescreva o método toString para que ele retorne uma string contendo os detalhes do cliente (nome, telefone, e email).

## Classe VetorClientes:
Esta classe deve reutilizar os métodos da classe Vetor que foi adaptada anteriormente para Strings.
- Método para Listar Clientes: Implemente um método que retorne todos os clientes armazenados no vetor.
- Implemente o método na classe para buscar clientes pelo nome.
- Implemente o método para filtrar clientes que tenham um determinado domínio de email (por exemplo, todos os clientes com email que termina em @exemplo.com).

## Classe Main:
- Crie um vetor com capacidade para 20 clientes.
- Insira 30 clientes no vetor utilizando um loop (explique como tratar a situação de exceder a capacidade do vetor).
- Realize operações de:
    - alteração;
    - exclusão;
    - inserção de clientes em posições específicas do vetor.
    - liste todos os clientes armazenados.