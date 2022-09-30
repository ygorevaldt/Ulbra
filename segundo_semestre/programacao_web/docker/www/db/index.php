<?php

$host = 'localhost:3306';
$user = 'root';
$password = '1q2w3e4r5t';
$dbName = 'pw_exemple';

$conn = new mysqli($host, $user, $password, $dbName);
if ($conn->connect_error) {
  die("Connection failed: $conn->connect_error");
}

$sql = "SELECT * FROM clients";
$result = $conn->query($sql);

$arrayClients =  array();
while ($line = $result->fetch_assoc()) {
  array_push($arrayClients, $line);
}

foreach ($arrayClients as $client) {
  echo $client['idClient'] . ' - ';
  echo $client['name'];
  echo '<br>';
}

$conn->close();
