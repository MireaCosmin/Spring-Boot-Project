package com.example.proiect_final.controller;


import com.example.proiect_final.model.Account;
import com.example.proiect_final.model.Shop;
import com.example.proiect_final.model.Storage;
import com.example.proiect_final.service.ShopService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("proiect")
public class ShopController {

    private final ShopService shopService;

    public ShopController( ShopService shopService) {
        this.shopService = shopService;
    }

    @PostMapping("shop/new")
    public ResponseEntity<Shop> saveShop(@RequestBody Shop shop) {
        return ResponseEntity.ok().body(shopService.saveNewShop(shop));
    }

    @GetMapping("shop/getAll")
    public ResponseEntity<List<Shop>> retrieveShops() {
        return ResponseEntity.ok().body(shopService.retrieveShops());
    }

    @GetMapping("shop/getStorageShop")
    public ResponseEntity<Storage> retrieveStorageShop(@RequestParam Integer shopId) {
        return ResponseEntity.ok().body(shopService.retrieveStorageShop(shopId));
    }
}
