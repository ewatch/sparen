package de.jan.banking.sparen.repository;

import de.jan.banking.sparen.entity.AccountAggregate;
import de.jan.banking.sparen.entity.AccountQueryEntity;
import de.jan.banking.sparen.event.BaseEvent;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class AccountQueryEntityManager {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    @Qualifier("accountAggregateEventSourcingRepository")
    private EventSourcingRepository<AccountAggregate> accountAggregateEventSourcingRepository;

    @EventSourcingHandler
    void on(BaseEvent event) {
        persistAccount(buildQueryAccount(getAccountFromEvent(event)));
    }

    private void persistAccount(AccountQueryEntity accountQueryEntity) {
        accountRepository.save(accountQueryEntity);
    }

    private AccountQueryEntity buildQueryAccount(AccountAggregate accountFromEvent) {
        AccountQueryEntity accountQueryEntity = findExistingOrCreateQueryAccount(accountFromEvent.getId());

        accountQueryEntity.setId(accountFromEvent.getId());
        accountQueryEntity.setAccountBalance(accountFromEvent.getAccountBalance());
        accountQueryEntity.setCurrency(accountFromEvent.getCurrency());
        accountQueryEntity.setStatus(accountFromEvent.getStatus());

        return accountQueryEntity;
    }

    private AccountQueryEntity findExistingOrCreateQueryAccount(String id) {
        return accountRepository.findById(id).isPresent() ? accountRepository.findById(id).get() : new AccountQueryEntity();
    }

    private AccountAggregate getAccountFromEvent(BaseEvent event) {
        return accountAggregateEventSourcingRepository.load(event.id.toString()).getWrappedAggregate().getAggregateRoot();
    }
}
