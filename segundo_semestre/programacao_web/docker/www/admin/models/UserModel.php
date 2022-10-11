<?php

class UserModel
{
  var $connection;

  public function __construct()
  {
    require_once('db/ConnectClass.php');
    $ConnectClass = new ConnectClass();
    $ConnectClass->openConnect();
    $this->connection = $ConnectClass->getConn();
  }

  public function consultUser($userName)
  {
    $sql = "
      SELECT * FROM users
      WHERE 
        user = '$userName'
    ";
    return $this->connection->query($sql);
  }
}
