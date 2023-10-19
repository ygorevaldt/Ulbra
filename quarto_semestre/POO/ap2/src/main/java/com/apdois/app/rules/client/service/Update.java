package com.apdois.app.rules.client.service;

import com.apdois.app.rules.client.model.Client;
import com.apdois.app.rules.shared.IUseCaseWithId;
import com.apdois.app.rules.shared.utils.MergeObjects;

import java.util.ArrayList;

public class Update implements IUseCaseWithId<Client, Void> {
    private IClientRepository repository;

    public Update(IClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public Void execute(String id, Client client) {
        ArrayList<Client> existingClient = this.repository.findById(id);
        if (existingClient.size() == 0) {
            throw new IllegalArgumentException("Cliente não cadastrado");
        }

        Client register = existingClient.get(0);
        Client updatedClient = MergeObjects.execute(register, client);
        this.repository.update(updatedClient);
        return null;
    }
}
