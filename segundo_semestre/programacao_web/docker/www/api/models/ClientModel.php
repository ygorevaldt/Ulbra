<?php

class ClientModel
{
  var $ConnectClass;

  public function __construct()
  {
    require_once('db/ConnectClass.php');
    $this->ConnectClass = new ConnectClass();
  }

  public function listClients()
  {
  }
}