package de.jan.banking.sparen.service;

import de.jan.banking.sparen.service.dto.AccountCreateDTO;
import de.jan.banking.sparen.service.dto.MoneyCreditDTO;
import de.jan.banking.sparen.service.dto.MoneyDebitDTO;

import java.util.concurrent.CompletableFuture;

public interface AccountCommandService {

    public CompletableFuture<String> createAccount(final AccountCreateDTO accountCreateDTO);
    public CompletableFuture<String> creditMoneyToAccount(final String accountNumber, final MoneyCreditDTO moneyCreditDto);
    public CompletableFuture<String> debitMoneyFromAccount(final String accountNumber, final MoneyDebitDTO moneyDebitDto);
}
