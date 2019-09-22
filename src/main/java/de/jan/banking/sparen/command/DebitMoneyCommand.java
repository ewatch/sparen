package de.jan.banking.sparen.command;

public class DebitMoneyCommand extends BaseCommand<String> {

    public final double debitAmount;
    public final String currency;

    public DebitMoneyCommand(final String id, final double debitAmount, final String currency) {
        super(id);
        this.debitAmount = debitAmount;
        this.currency = currency;
    }
}
