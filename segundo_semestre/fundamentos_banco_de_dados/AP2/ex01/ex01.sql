CREATE TABLE pessoas
(
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(50) NOT NULL,
  cpf CHAR(14) UNIQUE NOT NULL,
  telefone CHAR(15) NOT NULL,
  cep VARCHAR(10) NOT NULL,
  bairro VARCHAR(50) NOT NULL,
  rua VARCHAR(100) NOT NULL,
  num_casa INT NOT NULL
);

CREATE TABLE carros
(
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  codigo_marca VARCHAR(20) NOT NULL UNIQUE,
  marca VARCHAR(50) NOT NULL,
  ano INT NOT NULL,
  placa VARCHAR(10) UNIQUE NOT NULL,
  modelo VARCHAR(40) NOT NULL
);

CREATE TABLE aluguel
(
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  data_aluguel DATE NOT NULL,
  data_devolucao DATE NOT NULL,
  valor FLOAT NOT NULL,
  id_pessoa INT NOT NULL,
  id_carro INT NOT NULL,
  CONSTRAINT pessoas_fk_aluguel
    FOREIGN KEY(id_pessoa) REFERENCES pessoas(id)
      ON UPDATE cascade
      ON DELETE restrict,
  CONSTRAINT carros_fk_aluguel
    FOREIGN KEY(id_carro) REFERENCES carros(id)
      ON UPDATE cascade
      ON DELETE restrict
);