package com.poo.tde.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.poo.tde.rules.usuario.model.User;
import com.poo.tde.rules.usuario.service.IUserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
    private IUserRepository repository;

    public UserController(IUserRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public String create(@RequestBody String name, String cellphone) {
        User newUSer = new User(name, cellphone);
        this.repository.save(newUSer);
        return "Usuario criado com sucesso";
    }
}
