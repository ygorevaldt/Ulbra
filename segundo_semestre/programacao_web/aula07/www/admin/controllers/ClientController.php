<?php

class ClientController
{
  public function listClients()
  {
    require_once('models/ClientModel.php');
    $ClientModel = new ClientModel();
    $result = $ClientModel->listClients();

    $arrayClients = array();
    while ($line = $result->fetch_assoc()) {
      array_push($arrayClients, $line);
    }

    require_once('views/templates/header.php');
    require_once('views/client/listClients.php');
    require_once('views/templates/footer.php');
  }
}
