package com.example.proiect_java_mirea_cosmin.service;

import com.example.proiect_java_mirea_cosmin.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
}
