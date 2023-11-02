# AP2
Conforme as telas passadas, possuímos o protótipo de um aplicativo de entrega de comida,  devemos nos basear nessas telas para construir uma estrutura de banco de dados utilizando o  MongoDB, criando todas as collections e atributos necessários para que contemple a consistência e  persistência de todas as informações apresentadas. 

## 1 - Criar esquema de collections com suas propriedades. 
## 2 - Construir objetos de modelo. 
## 3 - Pelo menos uma collection deve possuir referência com outra. 

# A partir da construção deste esquema, devemos gerar alguns relatórios:

## 1 - Relatório que efetue uma busca por geolocalização (clientes ou restaurantes). 
```javascript
db.restaurante.find({
	"localizacao": {
		$near: {
			$geometry: {
				"type": "Point",
				"coordinates": [-23.55799, -46.63694]
			},
			$maxDistance: 6000
		}
	}
});
```

## 2 - Relatório de busque todos os pedidos por cliente
```javascript
    db.pedido.find({
    "cliente_id": ObjectId("6543f455b64f222e6d8743c7");
});
```

## 3 - Relatório que mostra todos os pedidos por cliente, mostrando os itens pertencentes ao pedido:
```javascript
db.pedido.aggregate([
    {
        $match: {
            "cliente_id": ObjectId("6543f455b64f222e6d8743c7")
        }
    },
    {
        $lookup: {
            from: "pedido_items",
            localField: "_id",
            foreignField: "pedido_id",
            as: "itens_pedido"
        }
    }
]);
```

## 4 - Relatório que busca pedidos por períodos definidos (data de início e fim):
```javascript
db.pedido.find({
    data: {
        $gte: ISODate("2023-01-01T00:00:00Z"),
        $lte: ISODate("2023-12-31T23:59:59Z")
    }
});
```

## 5 - Relatório que mostra uma lista de todos os clientes com o total de pedidos:
```javascript
db.pedido.aggregate([
    {
        $group: {
            _id: "$cliente_id",
            totalPedidos: { $sum: 1 }
        }
    },
    {
        $lookup: {
            from: "cliente",
            localField: "cliente_id",
            foreignField: "_id",
            as: "cliente_info"
        }
    }
]);
```