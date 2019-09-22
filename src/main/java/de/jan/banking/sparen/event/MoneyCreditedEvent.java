package de.jan.banking.sparen.event;

public class MoneyCreditedEvent extends BaseEvent<String> {

    public final double creditAmount;

    public final String currency;

    public MoneyCreditedEvent(final String id, final double creditAmount, final String currency) {
        super(id);
        this.creditAmount = creditAmount;
        this.currency = currency;
    }
}
