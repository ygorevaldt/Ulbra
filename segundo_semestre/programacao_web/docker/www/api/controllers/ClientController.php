<?php

class ClientController
{
  var $ClientModel;

  public function __construct()
  {
    require_once('models/ClientModel.php');
    $result->ClientModel = new ClientModel();
  }

  public function listClients()
  {
    $result = $this->ClientModel->listClients();
    $arrayClients = [];
    while ($line = $result->fetch_assoc()) {
      array_push($arrayClients, $line);
    }
    header('Content-type: application/json');
    echo json_encode($arrayClients);
  }

  public function consultClient($id_client)
  {
    $result = $this->ClientModel->consultClient($id_client);
    if ($arrayClient = $result->fetch_assoc()) {
      header('Content-type: application/json');
      echo json_encode($arrayClient);
    } else {
      header('Content-type: application/json');
      echo '{
        "error":"1",
        "message":"Cliente não encontrado"
      }';
    }
  }

  public function insertClient()
  {
    $client = json_decode(file_get_contents("php://input"));
    $arrayClient = (array) $client;
    $this->ClientModel->insertClient($arrayClient);
    header('Content-type: application/json');
    echo '{
        "success":"1",
        "message":"Cliente inserido"
      }';
  }

  public function updateClient($id_client)
  {
    $client = json_decode(file_get_contents("php://input"));
    $arrayClient = (array) $client;
    $this->ClientModel->updateClient($id_client, $arrayClient);
    header('Content-type: application/json');
    echo '{
        "success":"2",
        "message":"Cliente alterado"
      }';
  }

  public function deleteClient($id_client)
  {
    $this->ClientModel->deleteClient($id_client);
    header('Content-type: application/json');
    echo '{
        "success":"3",
        "message":"Cliente deletado "
      }';
  }
}