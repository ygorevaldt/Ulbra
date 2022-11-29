<?php

namespace App\Models;

use CodeIgniter\Model;

class ClientModel extends Model
{
  protected $table = 'clients';
  protected $primaryKey = 'id_client';
  protected $allowedFields = [
    'name',
    'email',
    'phone',
    'address'
  ];

  public function getUser($userName)
  {
    return $this->where('user', $userName)->first();
  }
}