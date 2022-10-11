<form action="?controller=client&action=updateClientAction&id=<?= $line['id_client'] ?>" method="post" class="container-fluid col-6 m-3 mt-5">
  <legend>Novo usuário:</legend>
  <fieldset>
    <div class="pb-3">
      <label for="name">Nome:</label>
      <input class="form-control" type="text" name="name" id="name" value="<?= $line['name'] ?>" required>
    </div class="pb-3">
    <div class="pb-3">
      <label for="email">E-mail:</label>
      <input class="form-control" type="email" name="email" id="email" value="<?= $line['email'] ?>" required>
    </div class="pb-3">
    <div class="pb-3">
      <label for="phone">Telefone:</label>
      <input class="form-control" type="text" name="phone" id="phone" value="<?= $line['phone'] ?>" required>
    </div class="pb-3">
    <div class="pb-3">
      <label for="phone">Endereço:</label>
      <input class="form-control" type="text" name="address" id="address" value="<?= $line['address'] ?>" required>
    </div class="pb-3">
    <div class="pt-2 text-end">
      <button class="btn btn-primary btn-sm" type="submit">Enviar</button>
    </div class="pb-3">
  </fieldset>
</form>