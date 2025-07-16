package com.ct.springboot_mariadb.service;

import com.ct.springboot_mariadb.model.Account;
import com.ct.springboot_mariadb.model.AccountRepository;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
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

    @Tool(description = "Get all accounts in the system")
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Tool(description = "Find an account by its ID")
    public Optional<Account> getAccountById(
            @ToolParam(description = "The ID of the account to find") Long id) {
        return accountRepository.findById(id);
    }

    @Tool(description = "Find an account by exact name match")
    public Optional<Account> getAccountByName(
            @ToolParam(description = "The exact name of the account to find") String name) {
        return accountRepository.findByName(name);
    }

    @Tool(description = "Search for accounts by partial name match (case-insensitive)")
    public List<Account> searchAccountsByPartialName(
            @ToolParam(description = "Part of the account name to search for") String namePattern) {
        return accountRepository.findByNameContainingIgnoreCase(namePattern);
    }
}