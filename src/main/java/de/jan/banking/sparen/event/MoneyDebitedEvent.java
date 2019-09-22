package de.jan.banking.sparen.event;

public class MoneyDebitedEvent extends BaseEvent<String> {

    public final double debitAmount;

    public final String currency;

    public MoneyDebitedEvent(final String id, final double debitAmount, final String currency) {
        super(id);
        this.debitAmount = debitAmount;
        this.currency = currency;
    }
}