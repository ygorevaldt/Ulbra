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
    $sql = "SELECT * FROM clients";
    return $this->connection->query($sql);
  }

  public function consultClient($id_client)
  {
    $sql = "SELECT * FROM clients WHERE id_cliente = $id_client";
    return $this->connection->query($sql);
  }

  public function insertClient($arrayClient)
  {
    $sql = "INSERT INTO clients (name, email, phone, address) VALUES (
      '{$arrayClient['name']}',
      '{$arrayClient['email']}',
      '{$arrayClient['phone']}',
      '{$arrayClient['address']}'
      )";
    return $this->connection->query($sql);
  }

  public function updateClient($id_client, $arrayClient)
  {
    $sql = "UPDATE clients SET
      name = '{$arrayClient['name']}',
      email = '{$arrayClient['email']}',
      phone = '{$arrayClient['phone']}',
      address = '{$arrayClient['address']}'
    WHERE
      id_cliente = {$id_client}
    ";
    return $this->connection->query($sql);
  }

  public function deleteClient($id_client)
  {
    $sql = "DELETE FROM clients WHERE id_client = {$id_client}";
    return $this->connection->query($sql);
  }
}