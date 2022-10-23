<?php

class ClientController
{
  var $ClientModel;

  public function __construct()
  {
    require_once('models/ClientModel.php');
    $this->ClientModel = new ClientModel();
  }

  public function listClients()
  {
    $result = $this->ClientModel->listClients();
  }

  public function consultClient()
  {
  }
}