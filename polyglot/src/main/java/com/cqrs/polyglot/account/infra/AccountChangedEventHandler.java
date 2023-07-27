package com.cqrs.polyglot.account.infra;

import com.cqrs.polyglot.account.command.domain.AccountChangedEvent;
import com.cqrs.polyglot.account.query.dao.AccountData;
import com.cqrs.polyglot.account.query.dao.AccountDataDao;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
public class AccountChangedEventHandler {
    private AccountDataDao dao;

    public AccountChangedEventHandler(AccountDataDao dao) {
        this.dao = dao;
    }

    @Async
    @EventListener(classes = AccountChangedEvent.class)
    public void handle(AccountChangedEvent event) {
        AccountData account = dao.findByAccountId(event.getId())
                        .orElseThrow(() -> new NoSuchElementException("account data not found."));

        AccountData newAccount = new AccountData(account.get_id(), account.getAccountId(), event.getPassword());
        dao.save(newAccount);
    }
}