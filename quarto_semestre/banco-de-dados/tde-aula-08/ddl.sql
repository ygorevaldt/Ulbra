-- Exercício 1 - Criação de Trigger:
-- Considerando que temos uma tabela chamada Produtos com as colunas ProdutoID e Quantidade.
-- Crie uma trigger chamada AtualizarEstoque que acione sempre que um novo registro for inserido na tabela Produtos. A trigger deve atualizar a quantidade em estoque para o novo produto inserido, definindo-a como 100.
DELIMITER //
    CREATE TRIGGER AtualizarEstoque
    BEFORE INSERT ON produtos
    FOR EACH ROW
    BEGIN
        SET NEW.quantidade = 100;
    END;
// DELIMITER ;


-- Exercício 2 - Criação de Trigger de Exclusão:
-- Suponha que você tenha uma tabela Clientes com as colunas ClienteID e Nome.
-- Crie uma trigger chamada RegistrarExclusaoCliente que acione sempre que um registro for excluído da tabela Clientes.
-- A trigger deve inserir um registro na tabela ClientesExcluidos com o nome do cliente excluído.
DELIMITER //
CREATE TRIGGER registrarExclusaoCliente
AFTER DELETE ON clientes
FOR EACH ROW
BEGIN
	INSERT INTO clientes_excluidos (cliente_id, nome) VALUES (OLD.cliente_id, OLD.nome);
END;
// DELIMITER ;

-- Exercício 3 - Criação de Stored Procedure Simples:
-- Suponha que você tenha uma tabela Funcionarios com as colunas FuncionarioID e Salario.
-- Crie uma stored procedure chamada AumentarSalario que aceita o ID de um funcionário e um valor de aumento salarial.
-- A stored procedure deve atualizar o salário do funcionário com base no valor fornecido.
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
END; 
// DELIMITER ;


-- Exercício 4 - Criação de Stored Procedure de Inserção:
-- Suponha que você tenha uma tabela Pedidos com as colunas PedidoID, ClienteID e DataPedido.
-- Crie uma stored procedure chamada InserirPedido que aceita o ID do cliente e a data do pedido como parâmetros e insere um novo pedido na tabela Pedidos.
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