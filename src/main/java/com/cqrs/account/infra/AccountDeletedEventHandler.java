package com.cqrs.account.infra;

import com.cqrs.account.command.domain.AccountDeletedEvent;
import com.cqrs.account.query.dao.AccountData;
import com.cqrs.account.query.dao.AccountDataDao;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
public class AccountDeletedEventHandler {
    private AccountDataDao dao;

    public AccountDeletedEventHandler(AccountDataDao dao) {
        this.dao = dao;
    }

    @Async
    @EventListener(classes = AccountDeletedEvent.class)
    public void handle(AccountDeletedEvent event) {
        AccountData account = dao.findByAccountId(event.getId())
                        .orElseThrow(() -> new NoSuchElementException("account data not found."));

        dao.delete(account);
    }
}