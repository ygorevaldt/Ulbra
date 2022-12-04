<h1 class="my-4 mx-3">Listagem de clientes</h1>

<table class="table table-sm my-5">
    <thead>
        <tr>
            <th>ID do cliente</th>
            <th>E-mail</th>
            <th>Nome</th>
            <th>Telefone</th>
            <th>Endereço</th>
            <th>Ações</th>
    </thead>
    <tbody>
        <?php
        foreach ($arrayClients as $client) {
        ?>
        <tr style="vertical-align: middle;">
            <td class="text-center">
                <?= $client['id_client'] ?>
            </td>
            <td>
                <?= $client['name'] ?>
            </td>
            <td>
                <?= $client['phone'] ?>
            </td>
            <td>
                <?= $client['email'] ?>
            </td>
            <td>
                <?= $client['address'] ?>
            </td>
            <td class="d-flex">
                <a class="text-primary btn btn-small me-2 fas fa-edit fs-6" href="<?= base_url("/admin/updateClient/{$client['id_client']}") ?>"></a>
                <form action="<?= base_url("/admin/deleteClient/{$client['id_client']}") ?>" method="post">
                    <button type="submit" class="text-danger btn btn-small fas fa-trash-alt fs-6"></button>
                </form>
            </td>
        </tr>
        <?php } ?>
    </tbody>
    </tr>

</table>