<?php

class ClientModel
{
  var $connection;

  public function __construct()
  {
    require_once("db/ConnectClass.php");
    $ConnectClass = new ConnectClass();
    $ConnectClass->openConnect();
    $this->connection = $ConnectClass->getConn();
  }

  public function listClients()
  {
    $sql = "SELECT * FROM clients";
    return $this->connection->query($sql);
  }
}
