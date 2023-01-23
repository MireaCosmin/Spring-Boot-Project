package com.example.proiect_final.service;

import com.example.proiect_final.model.*;
import com.example.proiect_final.repository.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTests {

    @InjectMocks
    private OrderService orderService;

    @Mock
    private OrderRepository orderRepository;
    @Mock
    private AccountRepository accountRepository;

    @Mock
    private ShopRepository shopRepository;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private StorageRepository storageRepository;

    @Test
    void retrieveOrders() {
        //arrange
        List<Order> orderList = new ArrayList<>();
        Order order = new Order();
        orderList.add(order);
        when(orderRepository.findAll()).thenReturn(orderList);
        //act
        List<Order> result = orderService.retrieveOrders();
        //assert
        assertEquals(orderList.size(), result.size());
    }

    /*
    @Test
    void saveNewOrder() {
        //arrange
        Account account = new Account(2000, "firstName1", "lastName1", "email1", LocalDate.of(2000,04,04));
        account.setAccountId(1);
        when(accountRepository.findById(1)).thenReturn(Optional.of(account));

        List<Product> productList = new ArrayList<>();
        List<Integer> productIdList = new ArrayList<>();

        Product product = new Product("Product", 20.0, 2);
        product.setQuantity(2);
        product.setPrice(20.0);
        product.setProductId(1);
        when(productRepository.findAll()).thenReturn(productList);

        productIdList.add(product.getProductId());
        productList.add(product);

        Storage storage = new Storage("Storage");
        storage.setStorageProductList(productList);

        Shop shop = new Shop("Adress", 1);
        shop.setStorage(storage);
        shop.setShopId(1);
        when(shopRepository.findById(1)).thenReturn(Optional.of(shop));

        Order order = new Order(40);
        order.setAccount(account);
        order.setOrderProductList(productList);
        order.setShop(shop);
        when(orderRepository.save(order)).thenReturn(order);

        //act
        Order result = orderService.saveNewOrder(order, account.getAccountId(), shop.getShopId(), productIdList);

        //assert
        assertEquals(order.getTotal(),result.getTotal());
    }
     */
}
