package com.cqrs.polyglot.account.command.domain;


import com.cqrs.polyglot.account.event.Events;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "account")
public class Account {

    @EmbeddedId
    private AccountId id;

    private String password;

    protected Account() {}

    public Account(AccountId id, String password) {
        setId(id);
        this.password = password;
        Events.raise(new AccountCreatedEvent(id.getValue(), password));
    }

    private void setId(AccountId id) {
        if(id == null) throw new NullPointerException("id cannot be null.");
        if(id.getValue().equals("")) throw new IllegalArgumentException("id cannot be blank");
        this.id = id;
    }

    public void change(String password) {
        this.password = password;
        Events.raise(new AccountChangedEvent(this.id.getValue(), password));
    }

    public void delete() {
        Events.raise(new AccountDeletedEvent(this.id.getValue()));
    }

    public AccountId getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }
}