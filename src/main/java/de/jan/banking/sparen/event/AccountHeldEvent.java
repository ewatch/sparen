package de.jan.banking.sparen.event;

import de.jan.banking.sparen.Status;

public class AccountHeldEvent extends BaseEvent<String> {

    public final Status status;

    public AccountHeldEvent(final String id, final Status status) {
        super(id);
        this.status = status;
    }
}
