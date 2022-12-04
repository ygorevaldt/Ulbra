<main class="container-fluid">
    <section class="d-flex align-items-center justify-content-between">
        <h1 class="my-4 mx-3">Listagem de clientes</h1>
        <form action="<?= base_url('admin/client/search') ?>" class="d-flex align-items-center">
            <label for="search" class="d-none">Buscar cliente</label>
            <input class="form-control" type="text" name="search" maxlength="100" placeholder="Buscar cliente">
            <button class="btn btn-secondary ms-2" type="submit"><i class="fas fa-search"></i></button>
        </form>
    </section>

    <div class="table-responsive">
        <table class="table table-sm my-5">
            <thead>
                <tr>
                    <th>ID do cliente</th>
                    <th>Nome</th>
                    <th>E-mail</th>
                    <th>Telefone</th>
                    <th>Endereço</th>
                    <th>Ações</th>
            </thead>
            <tbody>
                <?php
                foreach ($clients as $client) {
                ?>
                <tr style="vertical-align: middle;">
                    <td class="text-center">
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
                    <td class="d-flex">
                        <a class="text-primary btn btn-small me-2 fas fa-edit fs-6" href="<?= base_url("/admin/client/update/{$client['id_client']}") ?>"></a>
                        <form action="<?= base_url("/admin/delete/{$client['id_client']}") ?>" method="post" onsubmit="confirmDelete(event, this)">
                            <button type="submit" class="text-danger btn btn-small fas fa-trash-alt fs-6"></button>
                        </form>
                    </td>
                </tr>
                <?php } ?>
            </tbody>
            </tr>
        </table>
    </div>
    <div>
        <?php if (isset($pager)) {
            echo $pager->links('default', 'bootstrap_pagination');
        } ?>
    </div>
</main>