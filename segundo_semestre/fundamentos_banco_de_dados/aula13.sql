CREATE TABLE categorias
(
  codigo INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE produtos
(
  codigo INT AUTO_INCREMENT PRIMARY KEY,
  descricao VARCHAR(100),
  data_cadastro DATE NOT NULL,
  valor_unitario DECIMAL(12,2) NOT NULL DEFAULT 0,
  codigo_categoria INT NOT NULL,
  CONSTRAINT produto_tem_categoria
    FOREIGN KEY (codigo_categoria) REFERENCES categorias(codigo)
    ON DELETE restrict
    ON UPDATE cascade
);

CREATE TABLE fornecedores
(
  codigo INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE pedidos
(
  codigo INT AUTO_INCREMENT PRIMARY KEY
  data_pedido DATE NOT NULL,
  codigo_fornecedor INT NOT NULL,
  CONSTRAINT pedido_por_fornecedor
    FOREIGN KEY (codigo_fornecedor) REFERENCES fornecedores(codigo)
    ON DELETE restrict
    ON UPDATE cascade
);

CREATE TABLE pedido_itens
(
  id INT NOT NULL PK,
  codigo_pedido INT NOT NULL,
  valor_unitario DECIMAL(12,2) NOT NULL,
  quantidade DECIMAL(12,3) NOT NULL DEFAULT 0,
  CONSTRAINT pedidos_itens_fk_pedidos
    FOREIGN KEY (codigo_pedido) REFERENCES pedidos(codigo)
    ON DELETE restrict
    ON UPDATE cascade,
  codigo_produto INT NOT NULL,
  CONSTRAINT pedido_tem_muitos_produtos
    FOREIGN KEY (codigo_produto) REFERENCES produtos(codigo)
    ON DELETE restrict
    ON UPDATE cascade
);

-- Exercicio 03
ALTER TABLE fornecedores ADD data_ultima_compra DATE NOT NULL;

-- Exercicio 04
ALTER TABLE pedidos CHANGE data_pedido data_pedidoo;

-- Exercicio 05
ALTER TABLE produtos
DROP COLUMN data_cadastro;

-- Exercicio 07
ALTER TABLE fornecedores
ALTER COLUMN nome VARCHAR(80);

-- Exercicio 08
DROP TABLE fornecedores;
-- Consequencias desse drop
  -- De acordo com a integridade do banco, a tabela fornecedores não pode ser excluida. Se a tabela pudesse ser excluida todos os fornecedores dos pedidos registrados seriam apagados.

-- Exercicio 09
ALTER TABLE pedidos
ADD numero_pedido CHAR(50 NOT NULL);

-- Exercicio 10
INSERT INTO fornecedores (nome) VALUES ("value2");
INSERT INTO fornecedores (nome) VALUES ("value2");