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
    require_once('views/clients/listClients.php');
    require_once('views/templates/footer.php');
  }

  public function detailsClient($id_client)
  {
    require_once('models/ClientModel.php');
    $ClientModel = new ClientModel();
    $result = $ClientModel->consultClient($id_client);

    if ($line = $result->fetch_assoc()) {
      require_once('views/templates/header.php');
      require_once('views/clients/detailsClient.php');
      require_once('views/templates/footer.php');
    }
  }
}
