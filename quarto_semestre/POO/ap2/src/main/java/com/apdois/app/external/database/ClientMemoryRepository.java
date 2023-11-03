package com.apdois.app.external.database;

import com.apdois.app.rules.client.model.Client;
import com.apdois.app.rules.client.service.IClientRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class ClientMemoryRepository implements IClientRepository {
    private ArrayList<Client> clients = new ArrayList<>();

    @Override
    public void save(Client client) {
        this.clients.add(client);
    }

    @Override
    public ArrayList<Client> findAll() {
        return this.clients;
    }

    @Override
    public ArrayList<Client> findById(String id) {
        ArrayList<Client> clients = new ArrayList<>();
        UUID uuid = UUID.fromString(id);

        for(Client client : this.clients) {
            if (client.getId().getValue().equals(uuid)) {
                clients.add(client);
            }
        }
        return clients;
    }

    @Override
    public void update(Client updatedClient) {
        for(Client client : this.clients) {
            if (client.getId().getValue().equals(updatedClient.getId().getValue())) {
                int index = this.clients.indexOf(client);
                this.clients.set(index, updatedClient);
                return;
            }
        }
    }

    @Override
    public void delete(String id) {
        ArrayList<Client> clients = this.findById(id);
        if (clients.get(0) == null) {
            return;
        }
        this.clients.remove(clients.get(0));
    }
}
