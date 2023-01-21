package com.example.proiect_final.service;

import com.example.proiect_final.exceptions.InvalidUserAge;
import com.example.proiect_final.model.Account;
import com.example.proiect_final.model.Shop;
import com.example.proiect_final.repository.ShopRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class ShopService {

    private ShopRepository shopRepository;

    public ShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public Shop saveNewShop(Shop shop) {
        return accountRepository.save(account);
    }
}
