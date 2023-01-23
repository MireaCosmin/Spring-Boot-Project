package com.example.proiect_final.service;

import com.example.proiect_final.model.Product;
import com.example.proiect_final.model.Storage;
import com.example.proiect_final.repository.AccountRepository;
import com.example.proiect_final.repository.ProductRepository;
import com.example.proiect_final.repository.StorageRepository;
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
public class StorageServiceTests {

    @InjectMocks
    private StorageService storageService;

    @InjectMocks
    private ProductService productService;

    @Mock
    private StorageRepository storageRepository;

    @Mock
    private ProductRepository productRepository;

    @Test
    @DisplayName("Running save storage")
    void saveNewStorage() {
        //arrange
        Storage storage = new Storage("Storage name");
        when(storageRepository.save(storage)).thenReturn(storage);
        //act
        List<Integer> storageProductsIds = new ArrayList<>();
        Storage result = storageService.saveNewStorage(storage, storageProductsIds);
        //assert
        assertEquals(storage.getStorageName(), result.getStorageName());
    }

    @Test
    @DisplayName("Running retrieve storages")
    void retrieveStorages() {
        //arrange
        List<Storage> storageList = new ArrayList<>();
        Storage storage = new Storage("Storage name");
        storageList.add(storage);
        when(storageRepository.findAll()).thenReturn(storageList);
        //act
        List<Storage> result = storageService.retrieveStorages();
        //assert
        assertEquals(storageList.size(), result.size());
    }

    @Test
    void addProductToStorage() {
        //arrange
        Product product = new Product("Name", 20.0, 10);
        product.setProductId(1);
        when(productRepository.findById(1)).thenReturn(Optional.of(product));

        Storage storage = new Storage("Storage name");
        storage.setStorageId(1);
        when(storageRepository.findById(1)).thenReturn(Optional.of(storage));
        when(storageRepository.save(storage)).thenReturn(storage);

        //act
        Storage result = storageService.addProductToStorage(storage.getStorageId(), product.getProductId());

        //assert
        assertEquals(1, result.getStorageProductList().size());
    }


}
