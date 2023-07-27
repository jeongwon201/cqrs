package com.cqrs.polyglot.account.infra;

import com.cqrs.polyglot.account.command.domain.AccountCreatedEvent;
import com.cqrs.polyglot.account.query.dao.AccountData;
import com.cqrs.polyglot.account.query.dao.AccountDataDao;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AccountCreatedEventHandler {
    private AccountDataDao dao;

    public AccountCreatedEventHandler(AccountDataDao dao) {
        this.dao = dao;
    }

    @Async
    @EventListener(classes = AccountCreatedEvent.class)
    public void handle(AccountCreatedEvent event) {
        AccountData account = new AccountData(event.getId(), event.getPassword());
        dao.insert(account);
    }
}