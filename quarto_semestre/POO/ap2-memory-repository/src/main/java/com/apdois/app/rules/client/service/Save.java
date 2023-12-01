package com.apdois.app.rules.client.service;

import com.apdois.app.rules.shared.IUseCase;
import com.apdois.app.rules.client.model.Client;

public class Save implements IUseCase<Client, Void> {
    private IClientRepository repository;

    public Save(IClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public Void execute(Client client) {
        this.repository.save(client);
        return null;
    }
}
