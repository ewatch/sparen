package de.jan.banking.sparen.service.impl;

import de.jan.banking.sparen.entity.AccountQueryEntity;
import de.jan.banking.sparen.repository.AccountRepository;
import de.jan.banking.sparen.service.AccountQueryService;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountQueryServiceImpl implements AccountQueryService {

    private final EventStore eventStore;
    private final AccountRepository accountRepository;

    public AccountQueryServiceImpl(final EventStore eventStore, final AccountRepository accountRepository) {
        this.eventStore = eventStore;
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Object> listEventsForAccount(final String accountNumber) {
        return eventStore.readEvents(accountNumber).asStream().map(s -> s.getPayload()).collect(Collectors.toList());
    }

    @Override
    public AccountQueryEntity getAccount(String accountNumber) {
        return  accountRepository.findById(accountNumber).get();
    }
}
