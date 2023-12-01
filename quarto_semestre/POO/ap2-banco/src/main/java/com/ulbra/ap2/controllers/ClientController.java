package com.ulbra.ap2.controllers;

import com.ulbra.ap2.controllers.dto.ClientResponseDTO;
import com.ulbra.ap2.entities.Client;
import com.ulbra.ap2.services.ClientService;
import com.ulbra.ap2.services.utils.exeptions.NoRegisteredClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping ("client")
public class ClientController {
    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("create")
    public void create(@RequestBody Client client) {
        this.clientService.create(client);
    }

    @GetMapping("list")
    public List<ClientResponseDTO> list() {
        return this.clientService.list();
    }

    @GetMapping("list/{id}")
    public Optional<Client> listById(@PathVariable UUID id) {
        return this.clientService.listById(id);
    }


    @GetMapping("list/filter")
    public ArrayList<ClientResponseDTO> listByAge(@RequestParam Integer age) {
        return this.clientService.listByAge(age);
    }


    @PutMapping ("update/{id}")
    public String update(@PathVariable String id, @RequestBody Client client) {
        return this.clientService.update(id, client);
    }


    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable String id) {
        this.clientService.delete(id);
    }
}
