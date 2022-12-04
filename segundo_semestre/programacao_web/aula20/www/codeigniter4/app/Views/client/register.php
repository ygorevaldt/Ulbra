<form action="" method="post" class="container-fluid col-6 m-3 mt-5">
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