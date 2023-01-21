package com.example.proiect_final.controller;

import com.example.proiect_final.model.Account;
import com.example.proiect_final.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("proiect")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("account/new")
    public ResponseEntity<Account> saveAccount(@RequestBody Account account) {
        return ResponseEntity.ok().body(accountService.saveNewAccount(account));
    }

    @GetMapping("account/getAll")
    public ResponseEntity<List<Account>> retrieveAccounts() {
        return ResponseEntity.ok().body(accountService.retrieveAccounts());
    }

}
