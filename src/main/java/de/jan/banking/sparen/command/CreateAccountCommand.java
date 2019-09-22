package de.jan.banking.sparen.command;

public class CreateAccountCommand extends BaseCommand<String> {

    public final double accountBalance;
    public final String currency;

    public CreateAccountCommand(final String id, final double accountBalance, final String currency) {
        super(id);
        this.accountBalance = accountBalance;
        this.currency = currency;
    }

}
