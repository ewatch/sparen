package de.jan.banking.sparen.controller;

import de.jan.banking.sparen.entity.AccountQueryEntity;
import de.jan.banking.sparen.service.AccountQueryService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/bank-accounts")
@Api(value = "Account Queries", description = "Account Query Events Endpoint", tags = "Account Queries")
public class AccountQueryController {

    @Autowired
    private final AccountQueryService accountQueryServiceImpl;

    public AccountQueryController(AccountQueryService accountQueryService) {
        this.accountQueryServiceImpl = accountQueryService;
    }

    @GetMapping("/{accountNumber}/events")
    public List<Object> listEventsForAccount(@PathVariable(value = "accountNumber") final String accountNumber) {
        return this.accountQueryServiceImpl.listEventsForAccount(accountNumber);
    }

    @GetMapping("/{accountNumber}")
    public AccountQueryEntity getAccount(@PathVariable(value = "accountNumber") final String accountNumber) {
        return this.accountQueryServiceImpl.getAccount(accountNumber);
    }
}
