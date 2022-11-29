<article class="m-3 mt-5">

    <h1 class="mb-4 h2">Atualizar Cadastro do Cliente <?= $arrayClient['name'] ?></h1>
    <form action="/admin/updateClientAction/<?= $arrayClient['id_client'] ?>" method="post" class="container-fluid col-6 m-3 mt-5">
        <legend>Deixe seu contato:</legend>
        <fieldset>
            <div class="pb-3">
                <label for="name">Nome:</label>
                <input class="form-control" type="text" name="name" id="name" value="<?= $arrayClient['name'] ?>" required>
            </div class="pb-3">
            <div class="pb-3">
                <label for="email">E-mail:</label>
                <input class="form-control" type="email" name="email" id="email" value="<?= $arrayClient['email'] ?>" required>
            </div class="pb-3">
            <div class="pb-3">
                <label for="phone">Telefone:</label>
                <input class="form-control" type="text" name="phone" id="phone" value="<?= $arrayClient['phone'] ?>" required>
            </div class="pb-3">
            <div class="pb-3">
                <label for="address">Endereço</label>
                <input class="form-control" type="text" name="address" id="address" value="<?= $arrayClient['address'] ?>" required>
            </div>

            <div class="pt-2 text-end">
                <button class="btn btn-primary btn-sm" type="submit">Enviar</button>
            </div class="pb-3">
        </fieldset>
    </form>

</article>