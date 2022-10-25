package com.cqrs.account.query.application;

import com.cqrs.account.query.dao.AccountData;
import com.cqrs.account.query.dao.AccountDataDao;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AccountQueryService {
    private AccountDataDao dao;

    public AccountQueryService(AccountDataDao dao) {
        this.dao = dao;
    }

    public AccountData find(String id) {
        return dao.findByAccountId(id)
                .orElseThrow(() -> new NoSuchElementException("account data not found."));
    }

    public List<AccountData> findAll() {
        return dao.findAll();
    }
}