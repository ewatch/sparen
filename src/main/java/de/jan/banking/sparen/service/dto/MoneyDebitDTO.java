package de.jan.banking.sparen.service.dto;

public class MoneyDebitDTO {

    private final String currency;
    private final double debitAmount;

    public MoneyDebitDTO(final double debitAmount, final String currency) {
        this.debitAmount = debitAmount;
        this.currency = currency;
    }

    public double getDebitAmount() {
        return this.debitAmount;
    }

    public String getCurrency() {
        return this.currency;
    }
}
