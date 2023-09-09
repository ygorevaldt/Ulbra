-- Inserção de dados na tabela Clientes
INSERT INTO Clientes (ClienteID, Nome, DataNascimento)
VALUES
  (1, 'João Silva', '1990-05-15'),
  (2, 'Maria Santos', '1985-07-22'),
  (3, 'Pedro Almeida', '1995-02-10'),
  (4, 'Ana Pereira', '1998-11-30'),
  (5, 'Carlos Oliveira', '1980-09-05');

-- Inserção de dados na tabela Produtos
INSERT INTO Produtos (ProdutoID, Nome, Preco, Estoque)
VALUES
  (1, 'Camiseta', 19.99, 100),
  (2, 'Calça Jeans', 39.99, 75),
  (3, 'Tênis', 59.99, 50),
  (4, 'Óculos de Sol', 29.99, 30),
  (5, 'Relógio', 79.99, 20);

-- Inserção de dados na tabela Pedidos
INSERT INTO Pedidos (PedidoID, ClienteID, DataPedido)
VALUES
  (1, 1, '2023-09-01'),
  (2, 2, '2023-09-02'),
  (3, 3, '2023-09-03'),
  (4, 4, '2023-09-04'),
  (5, 5, '2023-09-05');

-- Inserção de dados na tabela ItensPedido
INSERT INTO ItensPedido (ItemID, PedidoID, ProdutoID, Quantidade, PrecoUnitario)
VALUES
  (1, 1, 1, 2, 19.99),
  (2, 1, 3, 1, 59.99),
  (3, 2, 2, 3, 39.99),
  (4, 3, 4, 2, 29.99),
  (5, 4, 5, 1, 79.99);

-- Inserção de dados na tabela HistoricoProdutos
INSERT INTO HistoricoProdutos (HistoricoID, ProdutoID, NomeProduto, Preco, DataAtualizacao)
VALUES
  (1, 1, 'Camiseta', 19.99, '2023-09-01 10:00:00'),
  (2, 2, 'Calça Jeans', 39.99, '2023-09-01 10:00:00'),
  (3, 3, 'Tênis', 59.99, '2023-09-01 10:00:00'),
  (4, 4, 'Óculos de Sol', 29.99, '2023-09-01 10:00:00'),
  (5, 5, 'Relógio', 79.99, '2023-09-01 10:00:00');

-- Inserção de dados na tabela CuponsDesconto
INSERT INTO CuponsDesconto (CupomID, Desconto, DataInsercao)
VALUES
  (1, 10.00, '2023-09-01'),
  (2, 15.00, '2023-09-02'),
  (3, 20.00, '2023-09-03'),
  (4, 5.00, '2023-09-04'),
  (5, 10.00, '2023-09-05');

-- Inserção de dados na tabela CarrinhoCompras
INSERT INTO CarrinhoCompras (CarrinhoID, ClienteID, Total)
VALUES
  (1, 1, 79.97),
  (2, 2, 119.97),
  (3, 3, 89.98),
  (4, 4, 109.97),
  (5, 5, 79.99);

-- Inserção de dados na tabela ItensCarrinho
INSERT INTO ItensCarrinho (ItemCarrinhoID, CarrinhoID, ProdutoID, Preco)
VALUES
  (1, 1, 1, 19.99),
  (2, 1, 3, 59.99),
  (3, 2, 2, 39.99),
  (4, 3, 4, 29.99),
  (5, 4, 5, 79.99);
