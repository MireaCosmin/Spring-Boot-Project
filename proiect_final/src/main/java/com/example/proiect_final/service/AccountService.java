package com.example.proiect_final.service;

import com.example.proiect_final.exceptions.InvalidUserAge;
import com.example.proiect_final.model.Account;
import com.example.proiect_final.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Service
public class AccountService {

    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    //save the account only if the age is over 14
    public Account saveNewAccount(Account account) {
        LocalDate today = LocalDate.now();
        Integer age = Period.between(account.getBirthDate(), today).getYears();
        if(age < 14) {
            throw new InvalidUserAge("Can't create an account if you are under 14 years old");
        }
        return accountRepository.save(account);
    }

    public List<Account> retrieveAccounts() {
        return accountRepository.findAll();
    }

}
