package com.apdois.app.rules.client.service;

import com.apdois.app.rules.client.model.Client;
import com.apdois.app.rules.shared.IUseCase;

import java.util.ArrayList;

public class FindByAge implements IUseCase<Integer, ArrayList<Client>> {
    private IClientRepository repostory;

    public FindByAge(IClientRepository repository) {
        this.repostory = repository;
    }

    @Override
    public ArrayList<Client> execute(Integer age) {
        ArrayList<Client> filterClients = new ArrayList<>();

        ArrayList<Client> clients = this.repostory.findAll();
        for (Client client : clients) {
            if (client.getBirthday().getAge() == age) {
                filterClients.add(client);
            }
        }

        return filterClients;
    }
}
