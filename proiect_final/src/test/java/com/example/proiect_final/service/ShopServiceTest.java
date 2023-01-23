package com.example.proiect_final.service;

import com.example.proiect_final.model.Product;
import com.example.proiect_final.model.Shop;
import com.example.proiect_final.model.Storage;
import com.example.proiect_final.repository.ShopRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ShopServiceTest {

    @InjectMocks
    private ShopService shopService;

    @Mock
    private ShopRepository shopRepository;

    @Test
    void saveNewShop() {
        //arrange
        Shop shop = new Shop("Adress", 1);
        when(shopRepository.save(shop)).thenReturn(shop);

        //act
        Shop result = shopService.saveNewShop(shop);

        //assert
        assertEquals(shop.getAdress(), result.getAdress());
    }

    @Test
    void retrieveShops() {
        //arrange
        List<Shop> shopList = new ArrayList<>();
        Shop shop = new Shop("Adress",1);
        shopList.add(shop);
        when(shopRepository.findAll()).thenReturn(shopList);

        //act
        List<Shop> result = shopService.retrieveShops();

        //assert
        assertEquals(shopList.size(), result.size());
    }

    @Test
    void retrieveStorageShop() {
        //arrange
        Storage storage = new Storage("Storage");

        Shop shop = new Shop("Adress",1);
        shop.setShopId(1);
        shop.setStorage(storage);
        when(shopRepository.findById(1)).thenReturn(Optional.of(shop));

        //act
        Storage result = shopService.retrieveStorageShop(shop.getShopId());

        //assert
        assertNotNull(result);
    }
}
