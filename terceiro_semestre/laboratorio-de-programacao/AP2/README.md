# Avaliação Parcial 2 - Laboratório de Programação.
Universidade Luterana do Brasil - Curso de Análise e Desenvolvimento de Sistemas.

## Objetivo:
Este trabalho visa aplicar conceitos práticos de programação orientada a objetos em Java,
incluindo classes, objetos, atributos, métodos, sobrecarga de métodos, herança, classes e
métodos abstratos.

## Descrição do Projeto:
Para este trabalho, você deve criar um sistema de gerenciamento para uma Biblioteca. O
sistema deve ser capaz de adicionar, atualizar e remover livros, bem como verificar a
disponibilidade de um livro. Cada livro deve ter um título, autor, ano de publicação e um
status para indicar se está disponível ou não.

## Etapas:

- Classe Produto: Crie uma classe abstrata chamada Produto com atributos comuns a todos
os produtos que a biblioteca poderia ter (por exemplo, título). Esta classe deve incluir
métodos para obter e definir os valores desses atributos (getters e setters). Inclua também
um método abstrato chamado detalhesDoProduto().

- Classe Livro: Crie uma classe Livro que estende a classe Produto. Adicione atributos
adicionais, como autor, ano de publicação e disponibilidade. Implemente o método
detalhesDoProduto() para retornar uma string que contenha todos os detalhes do livro.

- Classe Biblioteca: Crie uma classe Biblioteca que deve ter 5 livros como atributos. A classe
Biblioteca deve ter métodos para adicionar um livro (substituindo um livro existente caso
todos os 5 espaços estejam ocupados), remover um livro (definindo o livro correspondente
como null), atualizar os detalhes de um livro e verificar a disponibilidade de um livro.

- Sobrecarga de métodos: Implemente a sobrecarga de métodos na classe Livro. Por
exemplo, pode haver mais de um método setTitulo(), onde um aceita um String como
parâmetro e o outro aceita um String e um int para permitir um número de edição.
Não utilizar listas ou arrays.

- Entrega:
Você deve enviar o código-fonte do projeto em um arquivo .zip, além de um vídeo em que
você explica e depura o código, linha por linha. Você deve explicar cada parte do código,
incluindo como as classes interagem entre si e como os conceitos de POO foram aplicados.