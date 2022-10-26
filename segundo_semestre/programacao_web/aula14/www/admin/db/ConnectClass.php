<?php

class ConnectClass
{

  var $conn;

  public function openConnect()
  {
    $host = 'db:3306';
    $user = 'root';
    $password = '1q2w3e4r5t';
    $dbname = 'pw_exemple';

    $this->conn = new mysqli($host, $user, $password, $dbname);

    if ($this->conn->connect_error) {
      die("Connection failed:" . $this->conn->connect_error);
    }
  }

  public function getConn()
  {
    return $this->conn;
  }
}
