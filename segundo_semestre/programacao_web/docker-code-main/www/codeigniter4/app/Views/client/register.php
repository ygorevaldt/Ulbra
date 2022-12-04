<main class="container-fluid my-5 p-4 py-0">
    <form action="" method="post" class="container m-0 p-4 card mx-auto">
        <legend>Deixe seu contato:</legend>
        <fieldset>
            <div class="pb-3">
                <label for="name">Nome:</label>
                <input class="form-control" type="text" name="name" id="name" required maxlength="100" minlength="3">
            </div class="pb-3">
            <div class="pb-3">
                <label for="email">E-mail:</label>
                <input class="form-control" type="email" name="email" id="email" required maxlength="100" minlength="3">
            </div class="pb-3">
            <div class="pb-3">
                <label for="phone">Telefone:</label>
                <input class="form-control" type="text" name="phone" id="phone" required maxlength="20" minlength="3">
            </div class="pb-3">
            <div class="pb-3">
                <label for="gender">Gênero: </label>
                <input type="radio" name="gender" value="Masculino" required> Masculino
                <input type="radio" name="gender" value="Feminino" required> Feminino
                <input type="radio" name="gender" value="Outro" required> Outro
            </div class="pb-3">
            <div class="pb-3">
                <label for="acceptView" class="d-block">Termo de aceite: </label>
                <input class="" type="checkbox" name="accept" id="accept"> Desejo receber os comunicados do site.
            </div class="pb-3">

            <div class="pt-2 text-end">
                <button class="btn btn-primary btn-sm" type="submit">Enviar</button>
            </div class="pb-3">
        </fieldset>
    </form>
</main>