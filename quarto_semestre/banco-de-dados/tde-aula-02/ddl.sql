CREATE TABLE cidade
(
    id_cidade INT PRIMARY KEY NOT NULL,
    nome_cidade VARCHAR(50)
);

CREATE TABLE cliente
(
    id_cliente INT PRIMARY KEY NOT NULL,
    nome_cliente VARCHAR(50),
    idade_cliente INT,
    id_cidade INT,
    FOREIGN KEY (id_cidade) REFERENCES cidade(id_cidade)
);

CREATE TABLE pedido
(
    id_pedido INT PRIMARY KEY NOT NULL,
    id_cliente INT,
    data_pedido DATE,
    valor_pedido DECIMAL(10, 2),
    FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente)
);

INSERT INTO cidade (id_cidade, nome_cidade) VALUES
    (1, 'São Paulo'),
    (2, 'Rio de Janeiro'),
    (3, 'Belo Horizonte'),
    (4, 'Curitiba'),
    (5, 'Porto Alegre');

INSERT INTO cliente (id_cliente, nome_cliente, idade_cliente, id_cidade) VALUES
    (1, 'João Silva', 30, 1),
    (2, 'Maria Souza', 25, 2),
    (3, 'Pedro Santos', 28, 1),
    (4, 'Ana Oliveira', 22, 3),
    (5, 'Lucas Pereira', 35, 4);

INSERT INTO pedido (id_pedido, id_cliente, data_pedido, valor_pedido) VALUES
    (1, 1, '2023-08-01', 150.00),
    (2, 2, '2023-08-02', 200.50),
    (3, 3, '2023-08-02', 75.80),
    (4, 4, '2023-08-03', 120.00),
    (5, 5, '2023-08-04', 300.25),
    (6, 1, '2023-09-01', 150.00);

-- A) Obter o nome dos clientes que fizeram pelo menos um pedido com valor acima de R$200,00
SELECT c.nome_cliente AS 'Nome do cliente'
FROM cliente c
INNER JOIN pedido p ON c.id_cliente = p.id_cliente
WHERE p.valor_pedido > 200;

-- B) Obter o nome das cidades que têm clientes com idade média superior a 28 anos.
SELECT ci.nome_cidade AS 'Nome da cidade'
FROM cidade ci
INNER JOIN cliente cl ON cl.id_cidade = ci.id_cidade
GROUP BY ci.id_cidade
HAVING AVG(cl.idade_cliente) > 28;  

-- C) Obter o nome dos clientes que fizeram pedidos em todas as cidades disponíveis na tabela “Cidades".
SELECT c.nome_cliente AS 'Nome do cliente'
FROM cliente c
WHERE NOT EXISTS (
    SELECT id_cidade
    FROM cidade
    WHERE id_cidade NOT IN (
        SELECT DISTINCT ci.id_cidade
        FROM cidade ci
        JOIN cliente cl ON ci.id_cidade = cl.id_cidade
        JOIN pedido p ON cl.id_cliente = p.id_cliente
    )
);

-- D) Obter o nome das cidades que têm clientes que fizeram pedidos em datas diferentes
SELECT ci.nome_cidade AS 'Nome da cidade'
FROM cidade ci
INNER JOIN cliente cl ON ci.id_cidade = cl.id_cidade
INNER JOIN pedido p ON cl.id_cliente = p.id_cliente
GROUP BY ci.nome_cidade
HAVING COUNT(DISTINCT p.data_pedido) > 1;

-- E) Obter o nome dos clientes que têm o valor médio de pedidos maior que R$ 150,00
SELECT cl.nome_cliente AS 'Nome do cliente'
FROM cliente cl
INNER JOIN pedido pe ON cl.id_cliente = pe.id_cliente
GROUP BY cl.nome_cliente
HAVING AVG(pe.valor_pedido) > 150;

-- F) Obter o nome das cidades que têm clientes que fizeram pedidos em mais de um mês
SELECT ci.nome_cidade AS 'Nome da cidade'
FROM cidade ci
INNER JOIN cliente cl ON ci.id_cidade = cl.id_cidade
INNER JOIN pedido pe ON cl.id_cliente = pe.id_cliente
GROUP BY ci.nome_cidade
HAVING COUNT(DISTINCT DATE_FORMAT(pe.data_pedido, '%Y-%m')) > 1;

-- G) Obter o nome dos clientes que fizeram mais de três pedidos.
SELECT cl.nome_cliente AS 'Nome do cliente'
FROM cliente cl
INNER JOIN pedido pe ON cl.id_cliente = pe.id_cliente
GROUP BY cl.nome_cliente
HAVING COUNT(pe.id_pedido) > 3;

-- H) Obter o nome das cidades que têm clientes com idade entre 25 e 35 anos
SELECT ci.nome_cidade AS 'Nome da cidade'
FROM cidade ci
INNER JOIN cliente cl ON cl.id_cidade = ci.id_cidade
WHERE cl.idade_cliente BETWEEN 25 AND 35
GROUP BY ci.nome_cidade;
HAVING COUNT(cl.idade_cliente) BETWEEN 25 AND 35;