package de.jan.banking.sparen.service.impl;

import de.jan.banking.sparen.command.CreateAccountCommand;
import de.jan.banking.sparen.command.CreditMoneyCommand;
import de.jan.banking.sparen.command.DebitMoneyCommand;
import de.jan.banking.sparen.service.dto.AccountCreateDTO;
import de.jan.banking.sparen.service.AccountCommandService;
import de.jan.banking.sparen.service.dto.MoneyCreditDTO;
import de.jan.banking.sparen.service.dto.MoneyDebitDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class AccountCommandServiceImpl implements AccountCommandService {

    private final CommandGateway commandGateway;

    public AccountCommandServiceImpl(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }


    @Override
    public CompletableFuture<String> createAccount(AccountCreateDTO accountCreateDTO) {
        return commandGateway.send(new CreateAccountCommand(UUID.randomUUID().toString(), accountCreateDTO.getStartingBalance(), accountCreateDTO.getCurrency()));
    }

    @Override
    public CompletableFuture<String> creditMoneyToAccount(String accountNumber, MoneyCreditDTO moneyCreditDto) {
        return commandGateway.send(new CreditMoneyCommand(accountNumber, moneyCreditDto.getCreditAmount(), moneyCreditDto.getCurrency()));
    }

    @Override
    public CompletableFuture<String> debitMoneyFromAccount(String accountNumber, MoneyDebitDTO moneyDebitDto) {
        return commandGateway.send(new DebitMoneyCommand(accountNumber, moneyDebitDto.getDebitAmount(), moneyDebitDto.getCurrency()));
    }
}
