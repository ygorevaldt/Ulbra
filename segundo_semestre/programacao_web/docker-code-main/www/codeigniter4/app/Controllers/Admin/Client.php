<?php

namespace App\Controllers\Admin;

use App\Controllers\BaseController;
use App\Models\ClientModel;

class Client extends BaseController
{
    private $ClientModel;

    public function __construct()
    {
        $this->ClientModel = new ClientModel();
    }

    public function list()
    {
        // $seeder = \Config\Database::seeder();
        // $seeder->call('client');

        $data = [
            'clients' => $this->ClientModel->paginate(5),
            'pager' => $this->ClientModel->pager
        ];
        echo view('admin/templates/header');
        echo view('admin/client/list', $data);
        echo view('admin/templates/footer');
    }

    public function register()
    {
        echo view('admin/templates/header');
        echo view('admin/client/register');
        echo view('admin/templates/footer');
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

            echo view('admin/templates/header');
            echo view('admin/client/register'), $messageError;
            echo view('admin/templates/footer');
        } else {
            $this->ClientModel->insert($data);
            return redirect()->to(base_url('admin/clients/list'));
        }
    }

    public function update($idClient)
    {
        $data = [
            'client' => $this->ClientModel->find($idClient)
        ];
        echo view('admin/templates/header');
        echo view('admin/client/update', $data);
        echo view('admin/templates/footer');
    }

    public function updateAction($idClient)
    {
        $data = [
            'name' => $this->request->getVar('name'),
            'email' => $this->request->getVar('email'),
            'phone' => $this->request->getVar('phone'),
            'address' => $this->request->getVar('address')
        ];
        $this->ClientModel->update($idClient, $data);
        return redirect()->to(base_url('admin/clients/list'));
    }

    public function delete($idClient)
    {
        $this->ClientModel->delete($idClient);
        return redirect()->to(base_url('admin/clients/list'));
    }

    public function search()
    {
        $search = $this->request->getVar('search');

        if (empty($search)) {
            return redirect()->to(base_url('admin/clients/list'));
        }

        $data = [
            'clients' => $this->ClientModel->getClientsFor($search)
        ];

        echo view('admin/templates/header');
        echo view('admin/client/list', $data);
        echo view('admin/templates/footer');
    }
}