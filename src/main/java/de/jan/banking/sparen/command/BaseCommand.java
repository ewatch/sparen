package de.jan.banking.sparen.command;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

public class BaseCommand<T> {

    @TargetAggregateIdentifier
    public final T id;

    BaseCommand(T id) {
        this.id = id;
    }
}
