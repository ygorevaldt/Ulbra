-- 1: Crie uma Stored Procedure para inserir um novo corredor no banco de dados.
DELIMITER //
CREATE PROCEDURE inserirCorredor(
	IN pNome VARCHAR(255),
    IN pIdade INT,
    IN pSexo CHAR(1),
    IN pCidade VARCHAR(255),
    IN pEstado VARCHAR(2)
) 
BEGIN
	INSERT INTO corredores(Nome, Idade, Sexo, Cidade, Estado)
	VALUES (pNome, pIdade, pSexo, pCidade, pEstado);
END
// DELIMITER ;

CALL inserirCorredor('Algum Nome', 26, 'M', 'Alguma cidade', 'RS');

-- 2: Crie uma Stored Procedure para atualizar os detalhes de uma corrida.
DELIMITER //
CREATE PROCEDURE atualizarCorrida(
	IN pNome VARCHAR(100),
    IN pData DATE,
    IN pLocal VARCHAR(100),
    IN pDistancia DECIMAL(5,2)
) 
BEGIN
	UPDATE 
		corridas 
    SET 
		Nome = pNome,
		Data = pData, 
		Local = pLocal,
		Distancia = pDistancia
	WHERE
		CorridaID = 1 ;
END
// DELIMITER ;

CALL atualizarCorrida('Corrida Iron Man', '2023-09-02', 'Torres', 10.2);
SELECT * FROM corridas;

-- 3: Crie uma Stored Procedure para excluir um corredor pelo seu ID.
DELIMITER //
CREATE PROCEDURE excluirCorredor(
	IN pCorredorID INT
)
BEGIN
	DELETE FROM 
		inscricoes
	WHERE
		CorredorID = pCorredorID;
	DELETE FROM
		corredores
	WHERE
		CorredorID = pCorredorID;
END
// DELIMITER ;

SELECT * FROM corredores;
CALL excluirCorredor(5);

-- 4: Crie uma Stored Procedure para buscar todos os corredores de uma determinada cidade.
DELIMITER //
CREATE PROCEDURE buscarCorredoresPorCidade(
	IN pCidade VARCHAR(100)
) 
BEGIN
	SELECT Nome AS 'Nome'
    FROM corredores
    WHERE cidade = pCidade;
END
// DELIMITER ;

SELECT * FROM corredores;
CALL buscarCorredoresPorCidade('São Paulo');

-- 5: Crie uma Stored Procedure para contar o número de corridas que ocorreram antes de uma
-- determinada data.

DELIMITER //
CREATE PROCEDURE contarCorridasAntesData(
	IN pData DATE
)
BEGIN
	SELECT
		COUNT(CorridaID)
	FROM
		corridas
	WHERE Data <= pData;
END
// DELIMITER ;
SELECT * FROM corridas;
CALL contarCorridasAntesData('2023-09-03');

-- 6: Crie uma Stored Procedure para registrar a inscrição de um corredor em uma corrida.
DELIMITER //
CREATE PROCEDURE registrarCorredorEmCorrida(
	IN pCorredorID INT,
    IN pCorridaID INT,
	IN pDataInscricao DATE
)
BEGIN 
	INSERT INTO
		inscricoes (CorridaID, CorredorID, DataInscricao)
	VALUES(pCorridaID, pCorredorID, pDataInscricao);
END
// DELIMITER ;
SELECT * FROM inscricoes;
CALL registrarCorredorEmCorrida(1, 1, '2023-09-01');

-- 7: Crie uma Stored Procedure para retornar o nome e a data das últimas N corridas.
DROP PROCEDURE obterNomeDataPorQuantidadeDeCorridas;
DELIMITER //
CREATE PROCEDURE obterNomeDataPorQuantidadeDeCorridas(
	IN pLimit INT
)
BEGIN
	SELECT
		Nome,
        Data
	FROM corridas
    ORDER BY CorridaID DESC
    LIMIT pLimit;
END
// DELIMITER ;
SELECT * FROM corridas;
CALL obterNomeDataPorQuantidadeDeCorridas(1);


