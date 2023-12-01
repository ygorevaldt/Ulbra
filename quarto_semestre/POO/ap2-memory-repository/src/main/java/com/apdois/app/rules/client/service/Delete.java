package com.apdois.app.rules.client.service;

import com.apdois.app.rules.shared.IUseCase;

public class Delete implements IUseCase<String, Void> {
    private IClientRepository repository;

    public Delete(IClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public Void execute(String id) {
        this.repository.delete(id);
        return null;
    }
}
