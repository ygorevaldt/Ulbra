CREATE TABLE fabricante
(
  id INT PRIMARY KEY NOT NULL,
  nome VARCHAR(100) NOT NULL
);

CREATE TABLE produto
(
  id PRIMARY KEY NOT NULL,
  nome VARCHAR(100) NOT NULL,
  categoria VARCHAR(30) NOT NULL,
  preco FLOAT NOT NULL,
  id_fabricante INT NOT NULL,
  CONSTRAINT producao
  FOREIGN KEY(id_fabricante) REFERENCES fabricante(id)
);