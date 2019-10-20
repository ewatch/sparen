package de.jan.banking.sparen.service;

import de.jan.banking.sparen.entity.AccountQueryEntity;

import java.util.List;

public interface AccountQueryService {
    List<Object> listEventsForAccount(final String accountNumber);
    AccountQueryEntity getAccount(final String accountNumber);
}
