# TDE - EXERCICIOS 9
- MODELO:
```json
{
    "_id": "5f8c303e69b36812b01702a1",
    "date": "2023-07-15T10:30:00Z",
    "category": "Alimentos",
    "product": "Arroz",
    "quantitySold": 200,
    "value": 600
}
```

## 1 - Filtro por Data e Categoria:
Para o mês de agosto, você precisa criar um relatório de vendas que inclua apenas as vendas da
categoria "Eletrônicos". Crie uma consulta que filtre as vendas por categoria e data.
```typescript
// filtro 1
db.sales.find({"category": "Eletrônicos", "date": {$gte: "2023-11-12"}})
// filtro 2
db.sales.find({"category": "Eletrônicos", "date": "2023-10-12T10:30:00Z"})
```

## 2 - Projeção de Dados:
O relatório deve conter apenas informações sobre o nome do produto, a quantidade vendida e o
valor. Crie uma consulta que projete apenas esses campos específicos para o relatório.
```typescript
// filtro 1
db.sales.find({ _id: 0, product: 1, quantitySold: 1, value: 1 })
```

## 3 - Ordenação por Quantidade:
No relatório, os produtos devem ser listados em ordem decrescente de quantidade vendida. Isso
ajudará a identificar os produtos mais populares. Crie uma consulta que ordene as vendas por
quantidade em ordem decrescente.
```typescript
db.sales.find().sort({ quantitySold: -1 })
```
## 4 - Filtro por Valor Mínimo:
Você precisa gerar um relatório adicional que mostre apenas produtos com um valor de venda
superior a R$ 500. Crie uma consulta que filtre as vendas com base em um valor mínimo.
```typescript
db.sales.find({"value": {$gt: 500}})
```


## 5 - Limitação de Resultados:
Para manter o relatório conciso, você deve incluir apenas os 5 produtos mais vendidos na
categoria "Alimentos" no mês de julho. Crie uma consulta que limite os resultados a apenas 5
produtos com base na quantidade vendida.
```typescript
db.sales.find({"category": "Alimentos", "date": {$gte: "2023-07-01", $lt: "2023-08-01"}})
.sort({ quantitySold: -1 })
.limit(5)

```