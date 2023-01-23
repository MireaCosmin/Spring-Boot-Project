package com.example.proiect_final.service;

import com.example.proiect_final.model.Account;
import com.example.proiect_final.repository.AccountRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AccountServiceTests {

    @InjectMocks
    private AccountService accountService;

    @Mock
    private AccountRepository accountRepository;

    @Test
    @DisplayName("Running save account happy flow")
    void saveNewAccountHappyFlow() {
        //arrange
        LocalDate birthDate = LocalDate.of(2000,10,04);
        Account newAccount = new Account(20,"firstName", "lastName", "email", birthDate);
        when(accountRepository.save(newAccount)).thenReturn(newAccount);

        //act
        Account result = accountService.saveNewAccount(newAccount);

        //assert
        assertEquals(newAccount.getLastName(), result.getLastName());
    }


    @Test
    @DisplayName("Running save account with exception")
    void saveNewAccountException() {
        //arrange
        LocalDate birthDate = LocalDate.now();
        Account newAccount = new Account(20,"firstName", "lastName", "email", birthDate);
       // when(accountRepository.save(newAccount)).thenReturn(newAccount);
        //newAccount.setBirthDate(LocalDate.now());
        //act
        try {
            Account result = accountService.saveNewAccount(newAccount);
        } catch (RuntimeException e) {
            //assert
            assertEquals("Can't create an account if you are under 14 years old", e.getMessage());
        }
    }
}
