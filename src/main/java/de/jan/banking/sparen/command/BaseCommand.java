package de.jan.banking.sparen.command;

import org.axonframework.commandhandling.model.AggregateIdentifier;

public class BaseCommand<T> {

    @AggregateIdentifier
    public final T id;

    public BaseCommand(T id) {
        this.id = id;
    }
}
