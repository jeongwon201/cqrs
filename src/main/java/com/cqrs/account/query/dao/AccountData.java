package com.cqrs.account.query.dao;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document(collection = "account")
public class AccountData {

    @Id
    private String _id;
    private String accountId;
    private String password;

    protected AccountData() {}

    public AccountData(String accountId, String password) {
        this.accountId = accountId;
        this.password = password;
    }

    public AccountData(String _id, String accountId, String password) {
        this._id = _id;
        this.accountId = accountId;
        this.password = password;
    }

    public String get_id() {
        return _id;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getPassword() {
        return password;
    }
}