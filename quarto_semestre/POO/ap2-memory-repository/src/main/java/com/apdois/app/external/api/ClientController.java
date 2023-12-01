package com.apdois.app.external.api;

import com.apdois.app.rules.client.model.Client;
import com.apdois.app.rules.client.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("client")
public class ClientController {
    private final IClientRepository repository;
    private final Save save;
    private final Find find;
    private final FindByAge findByAge;
    private final Update update;
    private final Delete delete;

    @Autowired
    public ClientController(IClientRepository ClientMemoryRepository) {
        this.repository = ClientMemoryRepository;
        this.save = new Save(this.repository);
        this.find = new Find(this.repository);
        this.findByAge = new FindByAge(this.repository);
        this.update = new Update(this.repository);
        this.delete = new Delete(this.repository);
    }

    @GetMapping("/read")
    public ArrayList<Client> read() {
        return this.find.execute();
    }

    @GetMapping("/read/{id}")
    public ArrayList<Client> read(@PathVariable String id) {
        return this.find.execute(id);
    }

    @GetMapping("/read/filter")
    public ArrayList<Client> filterByAge(@RequestParam Integer age) {
        return this.findByAge.execute(age);
    }

    @PostMapping("/create")
    public void create(@RequestBody Client client) {
        this.save.execute(client);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable String id, @RequestBody Client client) {
        this.update.execute(id, client);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
        this.delete.execute(id);
    }

}
