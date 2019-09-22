package de.jan.banking.sparen.service.dto;

public class MoneyCreditDTO {

    private final String currency;
    private final double creditAmount;

    public MoneyCreditDTO(final double creditAmount, final String currency) {
        this.creditAmount = creditAmount;
        this.currency = currency;
    }

    public double getCreditAmount() {
        return this.creditAmount;
    }

    public String getCurrency() {
        return this.currency;
    }
}
