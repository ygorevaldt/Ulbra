package com.apdois.app.rules.shared;

public interface IUseCaseWithId<I, O> {
    O execute(String pk, I input);
}
