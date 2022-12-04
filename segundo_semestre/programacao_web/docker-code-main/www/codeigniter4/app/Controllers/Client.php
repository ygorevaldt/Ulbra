<?php

namespace App\Controllers;

use App\Models\ClientModel;
use CURLStringFile;

class Client extends BaseController
{

  private $ClientModel;

  public function __construct()
  {
    $this->ClientModel = new ClientModel();
  }

  public function list()
  {
    $data = [
      'clients' => $this->ClientModel->paginate(5),
      'pager' => $this->ClientModel->pager
    ];

    echo view('templates/header');
    echo view('client/list', $data);
    echo view('templates/footer');
  }

  public function register()
  {
    echo view('templates/header');
    echo view('client/register');
    echo view('templates/footer');
  }

  public function registerAction()
  {
    $data = [
      'name' => $this->request->getVar('name'),
      'email' => $this->request->getVar('email'),
      'phone' => $this->request->getVar('phone'),
      'address' => $this->request->getVar('address'),
    ];

    $data  = array_map('trim', $data);
    if (in_array('', $data)) {
      $messageError = '<span class="d-block text-danger">Preencha todos os campos</span>';

      echo view('templates/header');
      echo view('client/register'), $messageError;
      echo view('templates/footer');
    } else {
      $this->ClientModel->insert($data);
      return redirect()->to(base_url('site/home'));
    }
  }
}