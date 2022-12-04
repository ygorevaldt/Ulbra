<?php

namespace App\Database\Seeds;

use CodeIgniter\Database\Seeder;

class Client extends Seeder
{
    public function run()
    {
        $data = [
            'name' => 'Aluno 08',
            'phone' => '+55 (51)9 99999-9999',
            'email' => 'aluno@rede.ulbra.br',
            'address' => 'Rua da Ulbra 25'
        ];

        $this->db->table('clients')->insert($data);
    }
}