package com.cqrs.account.command.domain;

import com.cqrs.event.Event;

public class AccountDeletedEvent extends Event {
    private String id;

    public AccountDeletedEvent(String id) {
        super();
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
