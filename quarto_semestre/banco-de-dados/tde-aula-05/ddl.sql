CREATE TABLE corredores (
corredorID INT PRIMARY KEY,
nome VARCHAR(50),
idade INT,
sexo CHAR(1),
cidade VARCHAR(50),
estado VARCHAR(2)
);
CREATE TABLE categorias (
categoriaID INT PRIMARY KEY,
nome VARCHAR(50)
);
CREATE TABLE corridas (
corridaID INT PRIMARY KEY,
nome VARCHAR(100),
data DATE,
local VARCHAR(100),
distancia DECIMAL(5, 2)
);
CREATE TABLE inscricoes (
inscricaoID INT PRIMARY KEY,
corredorID INT,
corridaID INT,
categoriaID INT,
dataInscricao DATE,
FOREIGN KEY (corredorID) REFERENCES corredores (corredorID),
FOREIGN KEY (corridaID) REFERENCES corridas (corridaID),
FOREIGN KEY (categoriaID) REFERENCES categorias (categoriaID)
);
CREATE TABLE resultados (
resultadoID INT PRIMARY KEY,
corridaID INT,
corredorID INT,
tempo DECIMAL(6, 2),
posicao INT,
FOREIGN KEY (corridaID) REFERENCES corridas (corridaID),

Semipresencial 26/08 - Esquema Modelo 2

FOREIGN KEY (corredorID) REFERENCES corredores (corredorID)
);
-- Inserção de Dados de Exemplo
-- Corredores
INSERT INTO corredores (corredorID, nome, idade, sexo, cidade, estado)
VALUES
(3, 'Mariana Santos', 24, 'F', 'Belo Horizonte', 'MG'),
(4, 'Carlos Souza', 42, 'M', 'Curitiba', 'PR'),
(5, 'Lúcia Lima', 31, 'F', 'Recife', 'PE'),
(6, 'Rafael Fernandes', 29, 'M', 'Salvador', 'BA'),
(7, 'Sandra Oliveira', 28, 'F', 'Porto Alegre', 'RS'),
(8, 'Diego Moraes', 35, 'M', 'Fortaleza', 'CE'),
(9, 'Amanda Costa', 27, 'F', 'Brasília', 'DF'),
(10, 'Paulo Almeida', 39, 'M', 'Manaus', 'AM');
-- Categorias
INSERT INTO categorias (categoriaID, nome)
VALUES
(3, 'Iniciante'),
(4, 'Amador Plus');
-- Corridas
INSERT INTO corridas (corridaID, nome, data, local, distancia)
VALUES
(2, 'Corrida da Liberdade', '2023-10-20', 'Parque dos Poetas', 8.7);
-- Inscrições
INSERT INTO inscricoes (inscricaoID, corredorID, corridaID, categoriaID, dataInscricao)
VALUES
(2, 7, 2, 4, '2023-09-05'),
(3, 3, 2, 3, '2023-09-10'),
(4, 4, 2, 3, '2023-09-12'),
(5, 5, 2, 4, '2023-09-15');
-- Resultados
INSERT INTO resultados (resultadoID, corridaID, corredorID, tempo, posicao)
VALUES
(2, 2, 7, 72.5, 3),
(3, 2, 3, 54.8, 1),
(4, 2, 4, 89.3, 6),
(5, 2, 5, 68.1, 4);

-- 1) 
SELECT nome
FROM corredores
WHERE corredorID IN (
    SELECT corredorID
    FROM inscricoes
    WHERE corridaID = 2
);

-- 2) 
SELECT c.nome AS categoria, AVG(r.tempo) AS media_tempo
FROM resultados r
JOIN inscricoes i ON r.corridaID = i.corridaID AND r.corredorID = i.corredorID
JOIN categorias c ON i.categoriaID = c.categoriaID
WHERE r.corridaID = 2
GROUP BY c.nome;

-- 3) 
CREATE VIEW vw_inscricoes_corredores AS
SELECT i.inscricaoID, i.corredorID, c.nome AS nome_corredor, c.idade, c.sexo, c.cidade, c.estado, i.corridaID, i.categoriaID, i.dataInscricao
FROM inscricoes i
JOIN corredores c ON i.corredorID = c.corredorID;

