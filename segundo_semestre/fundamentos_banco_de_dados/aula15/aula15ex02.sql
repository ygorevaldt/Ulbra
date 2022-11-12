SELECT id_produto FROM produtos, vendas_itens, vendas 
WHERE produtos.id, vendas_itens.id, vendas.id >= '2022-10-01' AND data_venda <= '2022-10-31' 
ORDER BY vendas_itens.valor_unitario ASC;