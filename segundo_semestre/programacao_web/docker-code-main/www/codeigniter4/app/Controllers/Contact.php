<?php

namespace App\Controllers;

use App\Models\ClientModel;
use CURLStringFile;

class Client extends BaseController
{


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
            echo view('site/contact/register'), $messageError;
            echo view('templates/footer');
        } else {
            $this->ClientModel->insert($data);
            return redirect()->to(base_url('admin/clients/list'));
        }
    }
}