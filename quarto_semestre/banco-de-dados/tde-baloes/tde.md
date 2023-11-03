# 1. Encontre os balões próximos a uma localização específica

## Modelo do objeto
```javascript
const baloesModel = new mongoose.Schema({
  nome: { type: String },
  cor: { type: String },
  localizacao: {
    type: GeoJSON,
    required: true,
  },
});
```

## Consulta
```javascript
const balõesPróximos = await baloesModel.find({
  localizacao: {
    $near: {
      $geometry: {
        $type: "Point",
        $coordinates: [-22.9074, -43.1721],
      },
      $maxDistance: 10000,
    },
  },
});
```
Esta consulta retornará todos os balões que estão dentro de um raio de 10.000 metros da localização. <br><br>

# 2. Encontre os locais mais próximos a partir de um ponto de interesse

## Modelo do objeto
```javascript
const pontosDeInteresseModel = new mongoose.Schema({
  nome: { type: String },
  descricao: { type: String },
  localizacao: {
    type: GeoJSON,
    required: true,
  },
});
```

## Consulta
```javascript
const locaisPróximos = await pontosDeInteresseModel.find({
  localizacao: {
    $near: {
      $geometry: {
        $type: "Point",
        $coordinates: [-22.9074, -43.1721],
      },
      $maxDistance: 10000,
    },
  },
});
```
Esta consulta retornará todos os locais de interesse que estão dentro de um raio de 10.000 metros do ponto de interesse especificado.

# 3. Listar todos os funcionários com seus respectivos departamentos

## Modelo de objeto
```javascript
const funcionariosModel = new mongoose.Schema({
  nome: { type: String },
  sobrenome: { type: String },
  departamento_id: { type: mongoose.Schema.Types.ObjectId, ref: "departamentos" },
});

const departamentosModel = new mongoose.Schema({
  nome: { type: String },
});
```

## Consulta
```javascript
const funcionariosComDepartamentos = await funcionariosModel.aggregate([
  {
    $lookup: {
      from: "departamentos",
      localField: "departamento_id",
      foreignField: "_id",
      as: "departamento",
    },
  },
]);
```
Esta consulta retornará um array de documentos, onde cada documento representa um funcionário com seu respectivo departamento. O departamento é retornado como um documento da coleção "departamentos".

# Explicação
A consulta utiliza o operador $lookup para unir as duas coleções. O operador $lookup tem três parâmetros principais:

- from: <br> A coleção de origem.<br><br>
- localField:<br> O campo no documento de origem que será usado para unir as coleções.<br><br>
- foreignField:<br> O campo no documento de destino que será usado para unir as coleções.<br><br>
- as:<br> O nome do campo do documento de destino que será usado para armazenar o resultado da união. <br> Neste caso, o operador $lookup é usado para unir os documentos da coleção "funcionarios" com os documentos da coleção"departamentos". <br>O campo "departamento_id" no documento de origem é usado para unir as coleções. O campo "_id" no documento de destino é usado para unir as coleções. O resultado da união é armazenado no campo "departamento" do documento de destino.

A consulta retorna um array de documentos, onde cada documento representa um funcionário com seu respectivo departamento. O departamento é retornado como um documento da coleção "departamentos".