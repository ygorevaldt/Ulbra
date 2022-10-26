<?php
class UserController
{
  var $UserModel;

  public function __construct()
  {
    require_once('models/UserModel.php');
    $this->UserModel = new UserModel();
  }

  public function validateLogin()
  {
    $userName = $_POST['userName'];
    $password = $_POST['password'];


    $result = $this->UserModel->consultUser($userName);

    if ($line = $result->fetch_assoc()) {
      if ($password == $line['password']) {
        $_SESSION['user'] = $line;
        header('Location: index.php');
      } else {
        echo 'Senha inválida';
      }
    } else {
      echo 'Usuário não existe';
    }
  }
}
