-- 1: Crie um trigger que atualize automaticamente o preço total em uma tabela de carrinho
-- de compras sempre que um novo item for adicionado.
DELIMITER //
CREATE TRIGGER atualizaPrecoTotal
AFTER INSERT ON ItensCarrinho
FOR EACH ROW
BEGIN
    UPDATE CarrinhoCompras
    SET Total = (
        SELECT SUM(Preco)
        FROM ItensCarrinho ic
        WHERE ic.CarrinhoID = NEW.CarrinhoID
    )
    WHERE CarrinhoID = NEW.CarrinhoID;
END;
// DELIMITER ;

SELECT * FROM Produtos;
SELECT * FROM CarrinhoCompras WHERE CarrinhoID = 1;
INSERT INTO ItensCarrinho (ItemCarrinhoID, CarrinhoID, ProdutoID, Preco) VALUES (6, 1, 2, 39.99);

-- 2: Crie um trigger que impeça a exclusão de registros em uma tabela de clientes se o
-- cliente tiver pedidos associados.
DELIMITER //
	CREATE TRIGGER impedeExclusaoClienteComPedido
		BEFORE DELETE ON Clientes
		FOR EACH ROW
	BEGIN
		DELETE FROM Clientes
		WHERE ClienteID NOT IN (SELECT ClienteID FROM Pedidos);
	END;
// DELIMITER ;
SELECT * FROM Clientes;
SELECT * FROM pedidos;
DELETE FROM Clientes WHERE ClienteID = 1;

-- 3: Crie um trigger que registre automaticamente as atualizações feitas em uma tabela de
-- produtos na tabela de histórico de produtos.
DELIMITER //
    CREATE TRIGGER registraHistoricoProdutos
        AFTER UPDATE ON Produtos
        FOR EACH ROW
    BEGIN
        INSERT INTO HistoricoProdutos(ProdutoID, NomeProduto, Preco, DataAtualizacao)
        VALUES (
            NEW.ProdutoID,
            NEW.Nome,
            NEW.Preco,
            NOW()
        );
    END;
// DELIMITER ;
SELECT * FROM produtos;
SELECT * FROM historicoprodutos;
UPDATE Produtos SET Nome = 'Camiseta Preta' WHERE ProdutoID = 1;

-- 4: Crie um trigger que limite o número de inserções em uma tabela de cupons de
-- desconto para 10 cupons por dia.
DELIMITER //
CREATE TRIGGER LimitarInsercoesCupons
	BEFORE INSERT ON CuponsDesconto
	FOR EACH ROW
BEGIN
    DECLARE contador INT;
    SET contador = (SELECT COUNT(*) FROM CuponsDesconto WHERE DataInsercao = CURDATE());
    
    IF contador >= 10 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Limite diário de inserções de cupons atingido.';
    END IF;
END;
// DELIMITER ;

SELECT * FROM cuponsdesconto;

INSERT INTO cuponsdesconto(Desconto, datainsercao)
VALUES(50, CURRENT_DATE());

-- 5: Crie um trigger que atualize automaticamente o estoque de produtos sempre que um
-- pedido for concluído.
DELIMITER //
CREATE TRIGGER atualizaEstoque
	AFTER INSERT ON pedidos 
    FOR EACH ROW
BEGIN 
	DECLARE quantidadeSaidaItens INT;
    DECLARE produtoID INT;

    SELECT ProdutoID, Quantidade INTO produtoID, quantidadeSaidaItens
    FROM ItensPedido
    WHERE PedidoID = NEW.PedidoID;

    UPDATE Produtos
    SET Estoque = Estoque - quantidadeSaidaItens
    WHERE ProdutoID = produtoID;
END;
// DELIMITER ;

INSERT INTO Pedidos (PedidoID, ClienteID, DataPedido)
VALUES (7, 1, CURRENT_DATE());
INSERT INTO ItensPedido(ItemID, PedidoID, ProdutoId, Quantidade, PrecoUnitario)
VALUES (8, 7, 1, 7, 19.99);

SELECT * FROM itenspedido;
select * from produtos

-- 6: Crie um trigger que restrinja a atualização do campo DataNascimento na tabela de
-- clientes para datas futuras.
DELIMITER //
	CREATE TRIGGER restringeAtualizacaoDataNascimentoClientes
		BEFORE UPDATE ON clientes
		FOR EACH ROW
	BEGIN 

	IF NEW.DataNascimento > CURRENT_DATE() THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'Data de nascimento inválida.';
	END IF;

	END;
// DELIMITER ;
SELECT * FROM Clientes;
UPDATE Clientes SET DataNascimento = '2023-09-10' WHERE ClienteID = 1;





