CREATE TABLE Clientes ( 
    idCliente INT PRIMARY KEY, 
    nomeCliente VARCHAR(50),
    idadeCliente INT, 
    cidadeCliente VARCHAR(50)
);

CREATE TABLE Pedidos ( 
    idPedido INT PRIMARY KEY, 
    idCliente INT, 
    dataPedido DATE,
    valorPedido DECIMAL(10, 2), FOREIGN KEY (idCliente) REFERENCES Clientes(idCliente) 
);

INSERT INTO Clientes (idCliente, nomeCliente, idadeCliente, cidadeCliente) VALUES
(1, 'João', 30, 'São Paulo'),
(2, 'Maria', 25, 'Rio de Janeiro'),
(3, 'Pedro', 35, 'Belo Horizonte'),
(4, 'Ana', 28, 'Porto Alegre');

INSERT INTO Pedidos (idPedido, idCliente, dataPedido, valorPedido) VALUES
(101, 1, '2023-07-25', 150.00),
(102, 2, '2023-07-26', 250.50),
(103, 3, '2023-07-27', 180.75),
(104, 1, '2023-07-27', 75.25),
(105, 4, '2023-07-28', 300.00);

-- 1. Obter todos os clientes e seus respectivos pedidos.
SELECT cl.idCliente, cl.nomeCliente, cl.idadeCliente, cl.cidadeCliente, pe.dataPedido, pe.valorPedido
FROM Clientes cl
INNER JOIN Pedidos pe ON cl.idCliente = pe.idCliente;

-- 2. Obter o nome e a cidade dos clientes que fizeram pedidos.
SELECT cl.nomeCliente, cl.cidadeCliente
FROM Clientes cl
INNER JOIN Pedidos pe ON cl.idCliente = pe.idCliente
GROUP BY cl.nomeCliente, cl.cidadeCliente
HAVING COUNT(pe.idPedido) >= 1;


-- 3. Obter o nome dos clientes que ainda não fizeram pedidos.
SELECT cl.nomeCliente AS 'Nome do cliente'
FROM Clientes cl
LEFT JOIN Pedidos pe ON cl.idCliente = pe.idCliente
WHERE pe.idPedido IS NULL 

-- 4. Retorne o nome e a cidade dos clientes que fizeram pedidos com valor maior do que R$200.00
SELECT cl.nomeCliente, cl.cidadeCliente
FROM Clientes cl
INNER JOIN Pedidos pe ON cl.idCliente = pe.idCliente
WHERE pe.valorPedido > 200;