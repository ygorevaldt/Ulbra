package com.poo.tde.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.poo.tde.rules.usuario.model.User;
import com.poo.tde.rules.usuario.service.IUserRepository;

import java.util.ArrayList;

@RestController
@RequestMapping("/users")
public class UserController {
    IUserRepository repository;

    @Autowired
    public UserController(IUserRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public String create(@RequestBody String name, String cellphone) {
        User newUSer = new User(name, cellphone);
        this.repository.save(newUSer);
        return "Usuario criado com sucesso";
    }

    @GetMapping("/read")
    public ArrayList<User> read() {
        return this.repository.searchAll();
    }
}
