CREATE TABLE pesquisadores
(
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(50) NOT NULL
);

CREATE TABLE artigos
(
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  editora VARCHAR(50) NOT NULL,
  pag_inicio INT NOT NULL,
  pag_final INT NOT NULL,
  titulo VARCHAR(50) NOT NULL,
  cod_periodico INT NOT NULL UNIQUE,
  titulo_periodico VARCHAR(100) NOT NULL,
  id_pesquisador INT NOT NULL,
  CONSTRAINT pesquisadores_fk_artigos
    FOREIGN KEY(id_pesquisador) REFERENCES pesquisadores(id)
      ON UPDATE cascade
      ON DELETE restrict
);

-- listar o artigo com código 1234
SELECT * FROM artigos WHERE id = 1234;

-- Listar os artigos da editora Saraiva
SELECT * FROM artigos WHERE editora = 'Saraiva';

-- Listar os pesquisadores onde o nome inicia com João
SELECT * FROM pesquisadores WHERE nome LIKE 'João%';