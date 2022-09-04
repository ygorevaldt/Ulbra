<?php

class ClientController
{
  public function index()
  {
  }

  public function register()
  {
    require_once("views/templates/header.php");
    require_once("views/client/register.php");
    require_once("views/templates/footer.php");
  }

  public function registerView()
  {
    if (isset($_POST['accept'])) {
      $accept = "Aceito";
      $acceptView = "Termo aceito";
    } else {
      $accept = "Não aceito";
      $acceptView = "Termo não aceito";
    }

    $arrayClient = [
      'name' => $_POST['name'],
      'email' => $_POST['email'],
      'phone' => $_POST['phone'],
      'gender' => $_POST['gender'],
      'accept' => $accept,
      'acceptView' => $acceptView
    ];

    require_once


      require_once("views/templates/header.php");
    require_once("views/client/registerView.php");
    require_once("views/templates/footer.php");
  }

  public function listClients()
  {
    require_once("models/clientModel.php");
    $ClientModel = new ClientModel();
    $result = $ClientModel->listClients();

    $arrayClients = array();

    while ($line = $result->fetch_assoc()) {
      array_push($arrayClients, $line);
    }

    require_once("views/templates/header.php");
    require_once("views/client/listClients.php");
    require_once("views/templates/footer.php");
  }
}
