package de.jan.banking.sparen.event;

public class AccountCreatedEvent extends  BaseEvent<String> {

    public final double accountBalance;
    public final String currency;

    public AccountCreatedEvent(final String id, final double accountBalance, final String currency) {
        super(id);
        this.accountBalance = accountBalance;
        this.currency = currency;
    }
}
