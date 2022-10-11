<?
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
    $sql = "INSERT INTO clients (name, email, phone, address) VALUES ('{$arrayClient['name']}', '{$arrayClient['email']}', '{$arrayClient['phone']}', '{$arrayClient['address']}')";

    return $this->connection->query($sql);
  }

  public function updateClient($arrayClient)
  {
    $sql = "UPDATE clients
      SET 
        name = '{$arrayClient['name']}',
        email = '{$arrayClient['email']}',
        phone = '{$arrayClient['phone']}',
        address = '{$arrayClient['address']}'
      WHERE
        id_client = {$arrayClient['id_client']}";

    return $this->connection->query($sql);
  }

  public function deleteClient($id_client)
  {
    $sql = "DELETE FROM clients WHERE id_client = $id_client";
    return $this->connection->query($sql);
  }
}
