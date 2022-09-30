<h1 class="container-fluid py-5 px-0">
  Detalhes do usuário <?= $line['name'] ?>
</h1>

<table class="container-fluid table border">
  <thead>
  </thead>
  <tbody>
    <tr>
      <td>
        <strong>ID:</strong> <?= $line['id_client'] ?>
      </td>
    </tr>
    <tr>
      <td>
        <strong>Nome:</strong> <?= $line['name'] ?>
      </td>
    </tr>
    <tr>
      <td>
        <strong>Telefone:</strong> <?= $line['phone'] ?>
      </td>
    </tr>
    <tr>
      <td>
        <strong>E-mail:</strong> <?= $line['email'] ?>
      </td>
    </tr>
    <tr>
      <td>
        <strong>Enderesso:</strong> <?= $line['address'] ?>
      </td>
    </tr>
  </tbody>
</table>