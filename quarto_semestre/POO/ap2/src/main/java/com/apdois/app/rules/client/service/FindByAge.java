package com.apdois.app.rules.client.service;

import com.apdois.app.rules.client.model.Client;
import com.apdois.app.rules.shared.IUseCase;

import java.util.ArrayList;

public class Filter implements IUseCase<String, ArrayList<Client>> {
    private IClientRepository repostory;

    public Filter(IClientRepository repository) {
        this.repostory = repository;
    }

    @Override
    public ArrayList<Client> execute(String filter) {
        ArrayList<Client> filterClients = new ArrayList<>();

        ArrayList<Client> clients = this.repostory.findAll();
        for (Client client : clients) {
            
        }
    }
}
