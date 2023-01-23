package com.example.proiect_final.service;

import com.example.proiect_final.exceptions.InvalidUserAge;
import com.example.proiect_final.model.Account;
import com.example.proiect_final.model.Shop;
import com.example.proiect_final.model.Storage;
import com.example.proiect_final.repository.ShopRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Service
public class ShopService {

    private ShopRepository shopRepository;

    public ShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public Shop saveNewShop(Shop shop) {
        return shopRepository.save(shop);
    }

    public List<Shop> retrieveShops() {
        return shopRepository.findAll();
    }

    public Storage retrieveStorageShop(Integer shopId) {
        Shop shop = shopRepository.findById(shopId)
                .orElseThrow(() -> new RuntimeException("Shop with this id is not found!"));
        return shop.getStorage();
    }
}
