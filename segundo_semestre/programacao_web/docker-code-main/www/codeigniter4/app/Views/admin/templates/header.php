<!DOCTYPE html>
<html lang="pt-br ">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Font Awesome -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet" />
    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap" rel="stylesheet" />
    <!-- MDB -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/4.4.0/mdb.min.css" rel="stylesheet" />
    <!-- MDB -->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/4.4.0/mdb.min.js"></script>

    <!-- Css -->
    <!-- <link rel="stylesheet" href="assets/css/style.css"> -->

    <title>Painel admin</title>
</head>

<body>
    <header class="container-fluid text-center bg-secondary bg-dark p-2">
        <h1 class="text-white h2">
            Área administrativa do sistema
        </h1>
        <a class="text-primary" href="<?= base_url('/admin/logout') ?>">Sair</a>
    </header>
    <main class="container-fluid d-md-flex px-0">
        <nav class="p-3 col-md-2" style="background-color: grey;">
            <h2 class="text-white">Menu</h2>
            <section class="d-flex flex-column justify-content-between">
                <ul class="nav flex-column">
                    <li class=" nav-item">
                        <a class="nav-link text-white" href="<?= base_url('/admin') ?>">Início</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-white" href="<?= base_url('/admin/listClients') ?>">Clientes</a>
                    </li>
                    <li>
                        <a class="nav-link text-white" href="<?= base_url('/admin/register') ?>">Cadastrar Cliente</a>
                    </li>
                </ul>
                <ul class="nav flex-column">
                    <li class="nav-iten">
                        <a class="nav-link text-white" href="<?= base_url('/') ?>">Site</a>
                    </li>
                </ul>
            </section>
        </nav>
        <section class="p-3 col-md-10">