package com.cqrs.account.query.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AccountDataDao extends MongoRepository<AccountData, String> {
    Optional<AccountData> findByAccountId(String id);
}