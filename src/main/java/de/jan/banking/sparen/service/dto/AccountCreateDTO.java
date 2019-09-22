package de.jan.banking.sparen.service.dto;

public class AccountCreateDTO {

    private final String currency;
    private final double startingBalance;

    public AccountCreateDTO(final double startingBalance, final String currency) {
        this.startingBalance = startingBalance;
        this.currency = currency;
    }

    public double getStartingBalance() {
        return this.startingBalance;
    }

    public String getCurrency() {
        return this.currency;
    }

}
