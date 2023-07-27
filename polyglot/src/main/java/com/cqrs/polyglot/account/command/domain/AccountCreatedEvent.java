package com.cqrs.polyglot.account.command.domain;


import com.cqrs.polyglot.account.event.Event;

public class AccountCreatedEvent extends Event {
    private String id;
    private String password;

    public AccountCreatedEvent(String id, String password) {
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