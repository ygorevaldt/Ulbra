<h1>Listagem de Clientes</h1>

<table class="table">
  <tr>
    <th>ID do Cliente</th>
    <th>Nome</th>
    <th>Email</th>
    <th>Telefone</th>
    <th>Endereço</th>
    <th>Ação</th>
  </tr>

  <?php
  foreach ($arrayClients as $client) {
  ?>
    <tr>
      <td>
        <?= $client['id_client'] ?>
      </td>
      <td>
        <?= $client['name'] ?>
      </td>
      <td>
        <?= $client['email'] ?>
      </td>
      <td>
        <?= $client['phone'] ?>
      </td>
      <td>
        <?= $client['address'] ?>
      </td>
      <td>
        <a class="btn btn-small btn-primary" href="?controller=client&action=detailsClient&id=<?= $client['id_client'] ?>">Detalhes</a>
      </td>
      <td>
        <a class="btn btn-small btn-secondary" href="?controller=client&action=updateClient&id=<?= $client['id_client'] ?>">Editar</a>
      </td>
      <td>
        <a class="btn btn-small btn-danger" href="?controller=client&action=deleteClient&id=<?= $client['id_client'] ?>">Excluir</a>
      </td>
    </tr>
  <?php
  }
  ?>
</table>
<a class="btn btn-small btn-success" href="?controller=client&action=newClient">Adicionar cliente</a>