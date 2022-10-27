CREATE TABLE socios(
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(50) NOT NULL,
  cod_tipo_socio INT NOT NULL,
  descricao_tipo_socio VARCHAR(100)
);

CREATE TABLE servicos(
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  descricao VARCHAR(100) NOT NULL,
  mes_referencia DATE NOT NULL,
  valor DECIMAL(12,2) NOT NULL
);

CREATE TABLE enderecos(
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  cep VARCHAR(10) NOT NULL,
  uf CHAR(2) NOT NULL,
  cidade VARCHAR(50) NOT NULL,
  bairro VARCHAR(50) NOT NULL,
  rua VARCHAR(100) NOT NULL,
  numero INT NOT NULL,
  id_socio INT NOT NULL,
  CONSTRAINT socios_fk_enderecos
    FOREIGN KEY(id_socio) REFERENCES socios(id)
      ON UPDATE cascade
      ON DELETE restrict
);

CREATE TABLE socios_por_servicos(
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  data_utilizacao DATE NOT NULL,
  id_socio INT NOT NULL,
  id_servico INT NOT NULL,
  CONSTRAINT socios_fk_socios_por_servicos
    FOREIGN KEY(id_socio) REFERENCES socios(id)
      ON UPDATE cascade
      ON DELETE restrict,
  CONSTRAINT servicos_fk_socios_por_servicos
    FOREIGN KEY(id_servico) REFERENCES servicos(id)
      ON UPDATE cascade
      ON DELETE restrict
);

-- listar os serviços onde o valor pago é maior que R$500,00
SELECT * FROM servicos WHERE valor > 500.00;

-- Listar os pedidos onde o mês referência é janeiro de 2020
SELECT * FROM servicos WHERE mes_referencia >= '2020-01-01' AND mes_referencia <= '2020-01-30';

-- Listar os socios que moram na rua que tem o nome Barão do Rio Branco
SELECT * FROM endereços WHERE rua = 'Barão do Rio Branco';