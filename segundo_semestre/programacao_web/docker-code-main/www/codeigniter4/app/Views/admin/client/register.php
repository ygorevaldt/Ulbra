<style>
form {
    max-width: 600px;
}
</style>

<main class="container-fluid p-2">
    <form action="/admin/registerAction" method="post" class="container-fluid m-3">
        <legend>Deixe seu contato:</legend>
        <fieldset>
            <div class="pb-3">
                <label for="name">Nome:</label>
                <input class="form-control" type="text" name="name" id="name" required>
            </div class="pb-3">
            <div class="pb-3">
                <label for="email">E-mail:</label>
                <input class="form-control" type="email" name="email" id="email" required>
            </div class="pb-3">
            <div class="pb-3">
                <label for="phone">Telefone:</label>
                <input class="form-control" type="text" name="phone" id="phone" required>
            </div class="pb-3">
            <div class="pb-3">
                <label for="address">Endereço</label>
                <input class="form-control" type="text" name="address" id="address" required>
            </div>
            <div>
                <?php if (isset($messageError)) { ?>
                <p class="d-block text-danger"><?php echo $messageError ?></p>
                <?php } ?>
            </div>

            <div class="pt-2 text-end">
                <button class="btn btn-primary btn-sm" type="submit">Enviar</button>
            </div class="pb-3">
        </fieldset>
    </form>
</main>