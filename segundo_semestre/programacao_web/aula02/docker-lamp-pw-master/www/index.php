<!DOCTYPE html>
<html lang="pt-br">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="author" content="Ygor Evaldt">
  <!-- Bootstrap -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
  <!-- Bootstrap icons -->
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
  <!-- Css -->
  <link rel="stylesheet" href="assets/css/style.css">
  <!-- JS -->
  <script src="assets/JS/script.js"></script>

  <title>Aula 02</title>
</head>

<body>
  <?php require_once "./templates/header.php" ?>
  <main class="container-fluid d-lg-flex p-0">
    <?php

    require_once "./templates/menu.php";
    if (!isset($_GET['page'])) {
      require_once "./views/cidade01.php";
    }
    if (isset($_GET['page'])) {
      if ($_GET['page'] == 'cidade01') {
        require_once "./views/cidade01.php";
      } else if ($_GET['page'] == 'cidade02') {
        require_once "./views/cidade02.php";
      } else if ($_GET['page'] == 'cidade03') {
        require_once "./views/cidade03.php";
      }
    }
    ?>
  </main>
  <?php require_once "./templates/footer.php" ?>
</body>

</html>