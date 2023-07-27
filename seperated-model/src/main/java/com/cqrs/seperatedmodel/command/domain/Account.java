package com.cqrs.seperatedmodel.command.domain;

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
    }

    private void setId(AccountId id) {
        if(id == null) throw new NullPointerException("id cannot be null.");
        if(id.getValue().equals("")) throw new IllegalArgumentException("id cannot be blank");
        this.id = id;
    }

    public void change(String password) {
        this.password = password;
    }

    public AccountId getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }
}