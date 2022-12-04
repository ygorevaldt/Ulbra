<main class="container-fluid">
    <section class="d-flex align-items-center justify-content-between">
        <h1 class="my-4 mx-3">Listagem de clientes</h1>
        <form action="<?= base_url('/admin/clients/search') ?>" class="d-flex align-items-center">
            <label for="search" class="d-none">Buscar cliente</label>
            <input class="form-control" type="text" name="search" maxlength="100" placeholder="Buscar cliente">
            <button class="btn btn-secondary ms-2" type="submit"><i class="fas fa-search"></i></button>
        </form>
    </section>

    <table class="table table-sm my-5">
        <thead>
            <tr>
                <th>ID do contato</th>
                <th>Nome</th>
                <th>E-mail</th>
        </thead>
        <tbody>
            <?php
            foreach ($contacts as $contact) {
            ?>
            <tr style="vertical-align: middle;">
                <td class="">
                    <?= $contact['id_contact'] ?>
                </td>
                <td>
                    <?= $contact['name'] ?>
                </td>
                <td>
                    <?= $contact['email'] ?>
                </td>

            </tr>
            <?php } ?>

        </tbody>
        </tr>
    </table>
    <div>
        <?php echo $pager->links('default', 'bootstrap_pagination') ?>
    </div>
</main>