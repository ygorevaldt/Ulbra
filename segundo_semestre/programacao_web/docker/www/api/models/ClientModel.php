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

  public function consultClient($id_client)
  {
    $sql = "SELECT * FROM clients WHERE id_client = $id_client";
    return $this->connection->query($sql);
  }

  public function insertClient($arrayClient)
  {
    $name = $arrayClient['name'];
    $email = $arrayClient['email'];
    $phone = $arrayClient['phone'];
    $address = $arrayClient['address'];

    $sql = "INSERT INTO clients (name, email, phone, address) VALUES (
      '$name',
      '$email',
      '$phone',
      '$address'
      )";
    return $this->connection->query($sql);
  }

  public function updateClient($id_client, $arrayClient)
  {
    $name = $arrayClient['name'];
    $email = $arrayClient['email'];
    $phone = $arrayClient['phone'];
    $address = $arrayClient['address'];

    $sql = "UPDATE clients SET name = '$name', email = '$email', phone = '$phone', address = '$address' WHERE id_client = $id_client";
    return $this->connection->query($sql);
  }

  public function deleteClient($id_client)
  {
    $sql = "DELETE FROM clients WHERE id_client = {$id_client}";
    return $this->connection->query($sql);
  }
}