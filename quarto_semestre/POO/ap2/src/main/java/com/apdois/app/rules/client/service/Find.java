package com.apdois.app.rules.client.service;

import com.apdois.app.rules.shared.IUseCase;
import com.apdois.app.rules.client.model.Client;

import java.util.ArrayList;

public class Find implements IUseCase<String, ArrayList<Client>> {
    private IClientRepository repository;
    public Find(IClientRepository repository) {
        this.repository = repository;
    }

    public ArrayList<Client> execute() {
        return this.repository.findAll();
    }

    public ArrayList<Client> execute(String id) {
        return this.repository.findById(id);
    }
}
