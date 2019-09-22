package de.jan.banking.sparen.event;

import de.jan.banking.sparen.Status;

public class AccountActivatedEvent extends BaseEvent<String> {

    public final Status status;

    public AccountActivatedEvent(final String id, final Status status) {
        super(id);
        this.status = status;
    }
}
