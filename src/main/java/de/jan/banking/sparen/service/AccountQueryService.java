package de.jan.banking.sparen.service;

import java.util.List;

public interface AccountQueryService {
    public List<Object> listEventsForAccount(final String accountNumber);
}
