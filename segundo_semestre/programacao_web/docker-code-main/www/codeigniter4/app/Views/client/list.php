<style>
</style>

<main class="container-fluid my-5 p-4 py-0">
    <h1 class="my-4">Listagem de clientes</h1>

    <div class="card table-responsive">
        <table class="table">
            <thead>
                <tr>
                    <th>ID do cliente</th>
                    <th>Nome</th>
                    <th>E-mail</th>
                    <th>Telefone</th>
                    <th>Endereço</th>
            </thead>
            <tbody>
                <?php
                foreach ($clients as $client) {
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
                </tr>
                <?php } ?>
            </tbody>
        </table>
    </div>
    <div class="mt-3">
        <?php echo $pager->links('default', 'bootstrap_pagination') ?>
    </div>
</main>