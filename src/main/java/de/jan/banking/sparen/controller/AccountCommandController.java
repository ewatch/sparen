package de.jan.banking.sparen.controller;

import de.jan.banking.sparen.service.AccountCommandService;
import de.jan.banking.sparen.service.dto.AccountCreateDTO;
import de.jan.banking.sparen.service.dto.MoneyCreditDTO;
import de.jan.banking.sparen.service.dto.MoneyDebitDTO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "/bank-accounts")
@Api(value = "Account Commands", tags = "Account Commands")
public class AccountCommandController {

    @Autowired
    private final AccountCommandService accountCommandServiceImpl;

    public AccountCommandController(AccountCommandService accountCommandService) {
        this.accountCommandServiceImpl = accountCommandService;
    }

    @PostMapping
    public CompletableFuture<String> createAccount(@RequestBody final AccountCreateDTO accountCreateDTO) {
        return this.accountCommandServiceImpl.createAccount(accountCreateDTO);
    }

    @PutMapping(value = "/credits/{accountNumber}")
    public CompletableFuture<String> creditMoneyToAccount(@PathVariable(value = "accountNumber") final String accountNumber, @RequestBody final MoneyCreditDTO moneyCreditDTO) {
        return this.accountCommandServiceImpl.creditMoneyToAccount(accountNumber, moneyCreditDTO);
    }

    @PutMapping(value = "/debits/{accountNumber}")
    public CompletableFuture<String> debitMoneyFromAccount(@PathVariable(value = "accountNumber") final String accountNumber, @RequestBody final MoneyDebitDTO moneyDebitDTO) {
        return this.accountCommandServiceImpl.debitMoneyFromAccount(accountNumber, moneyDebitDTO);
    }
}
