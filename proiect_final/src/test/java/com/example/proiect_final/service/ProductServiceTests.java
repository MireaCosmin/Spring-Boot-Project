package com.example.proiect_final.service;

import com.example.proiect_final.model.Account;
import com.example.proiect_final.model.Product;
import com.example.proiect_final.model.Storage;
import com.example.proiect_final.repository.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTests {

    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

    @Test
    @DisplayName("Running save product happy flow")
    void saveNewProduct() {
        //arrange
        Product newProduct = new Product("Tricou", 50.0, 20);
        when(productRepository.save(newProduct)).thenReturn(newProduct);

        //act
        Product result = productService.saveNewProduct(newProduct);

        //assert
        assertEquals(newProduct.getName(), result.getName());
    }

    @Test
    @DisplayName("Running retrieve products")
    void retrieveProducts() {
        //arrange
        List<Product> productList = new ArrayList<>();
        Product newProduct = new Product("Tricou", 50.0, 20);
        productList.add(newProduct);
        when(productRepository.findAll()).thenReturn(productList);

        //act
        List<Product> result = productService.retrieveProducts();

        //assert
        assertEquals(productList.size(), result.size());
    }

}
