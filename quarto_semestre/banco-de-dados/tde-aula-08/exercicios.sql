-- Exercício 1 - Criação de Trigger:
CREATE TABLE produtos (
    produto_id INT NOT NULL AUTO_INCREMENT,
    quantidade INT,
    nome VARCHAR(255),
    PRIMARY KEY (produto_id)
);

DELIMITER //
    CREATE TRIGGER AtualizarEstoque
    BEFORE INSERT ON produtos
    FOR EACH ROW
    BEGIN
        SET NEW.quantidade = 100;
    END;
// DELIMITER ;

INSERT INTO produtos (nome) VALUES ('Produto 1');
SELECT * FROM produtos;

-- Exercício 2 - Criação de Trigger de Exclusão:
CREATE TABLE clientes (
	cliente_id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255),
    PRIMARY KEY (cliente_id)
);

CREATE TABLE clientes_excluidos (
	cliente_id INT NOT NULL,
    nome VARCHAR(255),
    PRIMARY KEY (cliente_id)
);

INSERT INTO clientes (nome) VALUES ('Alessandra');
INSERT INTO clientes (nome) VALUES ('Qualquer pessoa');

DELIMITER //
CREATE TRIGGER registrarExclusaoCliente
AFTER DELETE ON clientes
FOR EACH ROW
BEGIN
	INSERT INTO clientes_excluidos (cliente_id, nome) VALUES (OLD.cliente_id, OLD.nome);
END;
// DELIMITER ;

SELECT * FROM clientes;
DELETE FROM clientes WHERE cliente_id = 2;
SELECT * FROM clientes_excluidos;


-- Exercício 3 - Criação de Stored Procedure Simples:
CREATE TABLE funcionarios (
	funcionario_id INT NOT NULL AUTO_INCREMENT,
    salario DECIMAL(19, 2),
    PRIMARY KEY (funcionario_id)
);

DELIMITER //
CREATE PROCEDURE aumentarSalario(
	IN pFuncionario_id INT,
	IN pSalario DECIMAL(19, 2)
) 
BEGIN
	UPDATE 
		funcionarios 
    SET 
		salario = pSalario
	WHERE
		funcionario_id = pFuncionario_id;
END
// DELIMITER ;

INSERT INTO funcionarios (salario) VALUES (4000.00);
INSERT INTO funcionarios (salario) VALUES (3200.00);
CALL aumentarSalario(1, 5000.00);
SELECT * FROM funcionarios;

-- Exercício 4 - Criação de Stored Procedure de Inserção:
CREATE TABLE pedidos (
	pedido_id INT NOT NULL AUTO_INCREMENT,
    cliente_id INT NOT NULL,
    data_pedido DATE,
    PRIMARY KEY (pedido_id)
);

DELIMITER //
CREATE PROCEDURE inserirPedido(
	IN pCliente_id INT,
	IN pData_pedido DATE
) 
BEGIN
	INSERT INTO  
		pedidos (cliente_id, data_pedido)
    VALUES (
		pCliente_id,
        pData_pedido
    );
END;
// DELIMITER ;

CALL inserirPedido(1, '2023-09-14');

SELECT * FROM pedidos;



