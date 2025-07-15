package com.ct.springboot_mariadb.service;

import com.ct.springboot_mariadb.model.Account;
import com.ct.springboot_mariadb.model.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Optional<Account> getAccountById(Long id) {
        return accountRepository.findById(id);
    }

    public Optional<Account> getAccountByName(String name) {
        return accountRepository.findByName(name);
    }

    public List<Account> searchAccountsByPartialName(String namePattern) {
        return accountRepository.findByNameContainingIgnoreCase(namePattern);
    }
}