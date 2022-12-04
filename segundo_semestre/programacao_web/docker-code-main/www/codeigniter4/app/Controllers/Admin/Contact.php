<?php

namespace App\Controllers\Admin;

use App\Controllers\BaseController;
use App\Models\ContactModel;

class Contact extends BaseController
{
    private $ContactModel;

    public function __construct()
    {
        $this->ContactModel = new ContactModel();
    }

    public function list()
    {
        $data = [
            'contacts' => $this->ContactModel->paginate(5),
            'pager' => $this->ContactModel->pager
        ];
        echo view('admin/templates/header');
        echo view('admin/contact/list', $data);
        echo view('admin/templates/footer');
    }
}