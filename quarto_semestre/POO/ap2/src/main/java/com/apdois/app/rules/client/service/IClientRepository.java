package com.apdois.app.rules.client.service;

import com.apdois.app.rules.client.model.Client;

import java.util.ArrayList;

public interface IClientRepository {
    void save(Client client);
    ArrayList<Client> findAll();
    ArrayList<Client> findById(String id);
    void update(Client client);
    void delete(String id);
}
