-- 1 - Conforme modelo ER abaixo, cria um Database no MySQL ou de sua escolha.
CREATE DATABASE db_aula_17;

USE db_aula_17;

CREATE TABLE editoras
(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(40)
);

CREATE TABLE assuntos
(
    id CHAR(1) NOT NULL PRIMARY KEY,
    descricao VARCHAR(40)
);

CREATE TABLE autores
(
    matricula INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(40),
    cpf VARCHAR(11),
    endereco VARCHAR(50),
    data_nascimento DATE,
    nacionalidade VARCHAR(30)
);

CREATE TABLE livros
(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    id_assunto CHAR NOT NULL,
    id_editora INT NOT NULL,
    titulo VARCHAR(80),
    preco DECIMAL(12,2) NOT NULL,
    lancamento DATE,
    CONSTRAINT assuntos_fk_livros
        FOREIGN KEY(id_assunto) REFERENCES assuntos(id)
        ON UPDATE cascade
        ON DELETE restrict,
    CONSTRAINT editoras_fk_livros
        FOREIGN KEY(id_editora) REFERENCES editoras(id)
        ON UPDATE cascade
        ON DELETE restrict
);

CREATE TABLE autores_livros
(
    matricula_autores INT NOT NULL,
    id_livro INT NOT NULL,
    CONSTRAINT autores_fk_autores_livros
        FOREIGN KEY(matricula_autores) REFERENCES autores(matricula)
        ON UPDATE cascade
        ON DELETE restrict,
    CONSTRAINT livros_fk_autores_livros
        FOREIGN KEY(id_livro) REFERENCES livros(id)
        ON UPDATE cascade
        ON DELETE restrict
);

-- 2 – Crie os SQLs solicitados abaixo.
INSERT INTO editoras(nome) VALUES 
    ('Mirandela Editora'), 
    ('Editora Via-Norte'),
    ('Editora Ilhas Tijucas'),
    ('Maria José Editora');

INSERT INTO assuntos(id, descricao) VALUES
    ('B', 'Banco de Dados'),
    ('P', 'Programação'),
    ('R', 'Redes'),
    ('S', 'Sistemas Operacionais');

INSERT INTO livros(titulo, preco, lancamento, id_assunto, id_editora) VALUES
    ('Banco de Dados Para a Web', 31.20, '1999-01-10','B', 1),
    ('Programação em Linguagem C', 30.00, '1997-10-01', 'P', 1),
    ('Programação em Linguagem C++', 111.50, '1998-11-01', 'P', 3),
    ('Banco de Dados na Bio-Informatica', 48, null, 'B', 2),
    ('Redes de Computadores', 42, '1996-09-01', 'R', 2),
    ('Banco de Dados Distribuídos', 31.20, '1999-01-10','B', 1),
    ('Banco de Dados Distribuído', 31.20, '1999-01-10','B', 1);

-- 3 – Crie comandos SQLs que retorne os dados solicitados abaixo.

-- a) Monte um comando para excluir da tabela livros aqueles que possuem o código maior ou igual a 2, que possuem o preço maior que R$ 50,00 e que já foram lançados.
DELETE FROM livros WHERE id >= 2 AND preco > 50 AND lancamento < '2022-11-19';

-- b) Escreva o comando que seleciona as colunas NOME, CPF e ENDERECO, da tabela AUTOR, para aqueles que possuem a palavra ‘joão’ no nome.
INSERT INTO autores(nome, cpf, data_nascimento, nacionalidade) VALUES 
    ('João Cassio Costa', '12345678910', '1983-05-18', 'Brasileiro'),
    ('Alessandra Silveira', '04435480050', '2003-03-22', 'Brasileiro'),
    ('Ygor Evaldt', '03919344065', '1996-12-16', 'Brasileiro'),
    ('Ramon Lumertz', '10987654321', '1981-12-12', 'Brasileiro'),
    ('Maria Elena Schutt Da Silveira', '15975345610', '1963-04-09', 'Brasileiro');

SELECT nome, cpf, endereco FROM autores WHERE nome LIKE '%João%';

-- c) Excluir o livro cujo título é ‘BANCO DE DADOS DISTRIBUÍDO’ ou ‘BANCOS DE DADOS DISTRIBUÍDOS’. Somente essas duas opções devem ser consideradas.
DELETE FROM livros WHERE titulo LIKE 'Banco de Dados Distribuído%';

-- d) Selecione o nome e o CPF de todos os autores que nasceram após 01 de janeiro de 1990.
SELECT nome, cpf FROM autores WHERE data_nascimento > '1990-01-01';

-- e) Selecione a matrícula e o nome dos autores que possuem RIO DE JANEIRO no seu endereço.
INSERT INTO autores(nome, cpf, data_nascimento, endereco, nacionalidade) VALUES 
    ('Carioca da Gema', '12345678920', '2022-11-19', 'Rio De Janeiro', 'Brasileiro');

SELECT matricula, nome FROM autores WHERE endereco LIKE '%Rio De Janeiro%';

-- f) Atualize para zero o preço de todos os livros onde a data de lançamento for nula ou onde seu preço atual for inferior a R$ 55,00.
UPDATE livros SET preco = 0 WHERE lancamento IS NULL OR preco < 55;

-- g) Exclua todos os livros onde o assunto for diferente de ‘S’, ‘P’, ou ‘B’.
DELETE FROM livros WHERE id_assunto != 'S' AND id_assunto != 'P' AND id_assunto != 'B';

-- h) Escreva o comando para contar quantos são os autores cadastrados na tabela AUTORES.
SELECT COUNT(matricula) AS total_de_autores_cadastrados FROM autores;

-- i) Escreva o comando que apresenta qual o número médio de autores de cada livro. Você deve utilizar, novamente, a tabela AUTOR_LIVRO. 

-- j) Apresente o comando SQL para gerar uma listagem dos códigos dos livros que possuem a menos dois autores.

-- k) Escreva o comando para apresentar o preço médio dos livros por código de editora. Considere somente aqueles que custam mais de R$ 45,00.

-- l) Apresente o preço máximo, o preço mínimo e o preço médio dos livros cujos assuntos são ‘S’ ou ‘P’ ou ‘B’, para cada código de editora.

-- m) Altere o comando do exercício anterior para só considerar os livros que já foram lançados (data de lançamento inferior a data atual) e cujo o preço máximo é inferior a R$ 100,00.

