package com.cqrs.account.command.domain;

import com.cqrs.event.Event;

public class AccountChangedEvent extends Event {
    private String id;
    private String password;

    public AccountChangedEvent(String id, String password) {
        super();
        this.id = id;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }
}
