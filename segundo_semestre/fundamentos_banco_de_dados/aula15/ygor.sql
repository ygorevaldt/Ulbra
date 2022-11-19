-- Liste todos os produtos cadastrados e ordene por ordem alfabética de descrição.
SELECT descricao FROM produtos ORDER BY descricao ASC;

-- Lista os produtos que foram pedidos e o nome do fornecedor de cada pedido.
SELECT id, nome FROM produtos, pedido_itens, pedidos, fornecedores WHERE produtos.id = pedido_itens.id_produto AND pedidos.id_fornecedor = fornecedor.id;

-- Mostre os produtos que já foram pedidos e o nome da categoria a que ele pertence.
SELECT id_produto, id_categoria FROM produtos, pedido_itens, pedidos, categorias WHERE produtos.id = pedido_itens.id_produto AND produtos.id_categoria = categorias.id;

-- Mostre o nome do fornecedor, a data do último pedido e a descrição do produto que ele pediu.
SELECT nome, descricao, MAX(data) FROM fornecedores, produtos, pedido_itens, pedidos WHERE pedidos.id_fornecedor = fornecedor.id AND produtos.descricao = pedido_itens.descricao;