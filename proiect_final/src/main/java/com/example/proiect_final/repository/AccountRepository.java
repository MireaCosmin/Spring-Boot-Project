package com.example.proiect_final.repository;

import com.example.proiect_final.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {

}
