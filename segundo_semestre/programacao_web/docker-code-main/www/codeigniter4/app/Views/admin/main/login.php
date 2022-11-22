<!DOCTYPE html>
<html>

<head>
    <title>Exemplo Login</title>
    <!-- Font Awesome -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet" />
    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap" rel="stylesheet" />
    <!-- MDB -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/4.4.0/mdb.min.css" rel="stylesheet" />
    <!-- MDB -->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/4.4.0/mdb.min.js"></script>

    <style>
    #tela-login {
        max-width: 400px;
    }
    </style>
</head>

<body>
    <div id="tela-login" class="container pt-5">
        <h1 class="py-4 text-center fs-3">Login no sistema</h1>
        <section class="container card">
            <form action="<?= base_url('admin/validateLogin') ?>" method=POST name="formulario" id="formulario" class="py-4 px-2">
                <div class="form-group">
                    <label>Login</label>
                    <input type="text" class="form-control" name="login" placeholder="Digite o usuário">
                </div>
                <div class="form-group pt-2">
                    <label>Senha</label>
                    <input type="password" class="form-control" name="password" placeholder="Digite sua senha">
                </div>
                <div class="d-flex justify-content-end pt-3">
                    <input role="button" class="login btn btn-primary btn-sm" type="submit" name="Enviar" value="Fazer Login">
                </div>
            </form>
        </section>
    </div>
</body>

</html>