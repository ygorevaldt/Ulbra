-- Tabelas
-- Criação da tabela Clientes
CREATE TABLE Clientes (
    ClienteID INT PRIMARY KEY,
    Nome VARCHAR(100),
    DataNascimento DATE
);
-- Criação da tabela Produtos
CREATE TABLE Produtos (
    ProdutoID INT PRIMARY KEY,
    Nome VARCHAR(100),
    Preco DECIMAL(10, 2),
    Estoque INT
);
-- Criação da tabela Pedidos
CREATE TABLE Pedidos (
    PedidoID INT PRIMARY KEY,
    ClienteID INT,
    DataPedido DATE,
    FOREIGN KEY (ClienteID) REFERENCES Clientes(ClienteID)
);
-- Criação da tabela ItensPedido
CREATE TABLE ItensPedido (
    ItemID INT PRIMARY KEY,
    PedidoID INT,
    ProdutoID INT,
    Quantidade INT,
    PrecoUnitario DECIMAL(10, 2),
    FOREIGN KEY (PedidoID) REFERENCES Pedidos(PedidoID),
    FOREIGN KEY (ProdutoID) REFERENCES Produtos(ProdutoID)
);
-- Criação da tabela HistoricoProdutos
CREATE TABLE HistoricoProdutos (
    HistoricoID INT PRIMARY KEY,
    ProdutoID INT,
    NomeProduto VARCHAR(100),
    Preco DECIMAL(10, 2),
    DataAtualizacao DATETIME
);
-- Criação da tabela CuponsDesconto
    CREATE TABLE CuponsDesconto (
    CupomID INT PRIMARY KEY,
    Desconto DECIMAL(5, 2),
    DataInsercao DATE
);
-- Criação da tabela CarrinhoCompras
CREATE TABLE CarrinhoCompras (
    CarrinhoID INT PRIMARY KEY,
    ClienteID INT,
    Total DECIMAL(10, 2),
    FOREIGN KEY (ClienteID) REFERENCES Clientes(ClienteID)
);
-- Criação da tabela ItensCarrinho
CREATE TABLE ItensCarrinho (
    ItemCarrinhoID INT PRIMARY KEY,
    CarrinhoID INT,
    ProdutoID INT,
    Preco DECIMAL(10, 2),
    FOREIGN KEY (CarrinhoID) REFERENCES CarrinhoCompras(CarrinhoID),
    FOREIGN KEY (ProdutoID) REFERENCES Produtos(ProdutoID)
);
