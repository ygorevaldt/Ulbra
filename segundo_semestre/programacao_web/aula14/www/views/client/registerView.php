<article class="m-3 mt-5">
  <h1 class="mb-4 h2">Registros de clientes</h1>
  <table class="table table-hover border">
    <caption style="display: table-caption;">
      Registro do cliente
    </caption>
    <thead>
      <tr>
        <th>Nome</th>
        <th>E-mail</th>
        <th>Telefone</th>
        <th>Gênero</th>
        <th>Termo De aceite</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td><?= $arrayClient['name'] ?></td>
        <td><?= $arrayClient['email'] ?></td>
        <td><?= $arrayClient['phone'] ?></td>
        <td><?= $arrayClient['gender'] ?></td>
        <td><?= $arrayClient['accept'] ?></td>
      </tr>
    </tbody>
  </table>
  <button class="btn btn-primary" onclick="printDiv()">Imprimir cadastro</button>
</article>