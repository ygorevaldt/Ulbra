package com.tdeauladoze.app.rules.shared;

public interface IUseCase<I, O> {
    O execute(I input);
}
