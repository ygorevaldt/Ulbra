<?php
namespace app\Controllers;

use App\Controllers\BaseController;
use App\Models\ClientModel;

class Client extends BaseController{
  public function listClients()
  {
    $ClientModel = new ClientModel();
    $ClientModel -> findAll();

    $data = [
      'arrayClients' => $ClientModel -> findAll()
    ];

    echo view('templates/header');
    echo view('client/listClients', $data);
    echo view('templates/footer');
  }
}
