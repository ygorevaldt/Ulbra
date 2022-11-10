CREATE DATABASE db_relacional;

USE db_relacional;

CREATE TABLE postagens
(
  id INT AUTO_INCREMENT PRIMARY KEY,
  titulo VARCHAR(50) NOT NULL,
  data_postagem DATE NOT NULL
);

CREATE TABLE mensagens
(
  id INT AUTO_INCREMENT PRIMARY KEY,
  descricao VARCHAR(200) NOT NULL,
  id_postagem INT NOT NULL,
  CONSTRAINT fk_postagens 
    FOREIGN KEY (id_postagem) REFERENCES postagens(id)
    ON UPDATE RESTRICTgit
    ON DELETE CASCADE 
);

-- INSERT
INSERT INTO postagens (titulo, data_postagem) VALUES ('Terminal', '2022-11-09');
INSERT INTO mensagens (descricao, id_postagem) VALUES ('Banco de dados criado diretamente pelo terminal', 1);
INSERT INTO postagens (titulo, data_postagem) VALUES ('Exemplo a ser deletado', '2022-11-09');
INSERT INTO mensagens (descricao, id_postagem) VALUES ('Delete deu certo', 2);

-- UPDATE
UPDATE postagens SET titulo = 'Database Pelo Terminal' WHERE id = 1;

-- DELETE
DELETE FROM postagens WHERE id = 2;

-- SELECT
SELECT titulo FROM postagens WHERE id = 1;