use db_banco_de_dados_as;

CREATE TABLE atleta (
	id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    idade INT NOT NULL,
    esporte VARCHAR(255) NOT NULL,
    equipe VARCHAR(255) NOT NULL
);