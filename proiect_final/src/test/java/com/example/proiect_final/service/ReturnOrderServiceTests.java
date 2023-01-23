package com.example.proiect_final.service;

import com.example.proiect_final.model.*;
import com.example.proiect_final.repository.OrderRepository;
import com.example.proiect_final.repository.ReturnOrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ReturnOrderServiceTests {

    @InjectMocks
    private ReturnOrderService returnOrderService;

    @Mock
    private ReturnOrderRepository returnOrderRepository;

    @Mock
    private OrderRepository orderRepository;


    @Test
    void saveNewReturnOrder() {
        //arrange
        Account account = new Account(2000, "firstName1", "lastName1", "email1", LocalDate.of(2000, 04, 04));

        Product product = new Product("Tricou", 50.0, 20);

        Storage storage = new Storage("Storage 1");
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        storage.setStorageProductList(productList);

        Shop shop = new Shop("Adresa shop 1", 1);
        shop.setStorage(storage);

        Order order = new Order(20.0);
        order.setOrderId(1);
        order.setAccount(account);
        order.setShop(shop);
        order.setOrderProductList(productList);
        when(orderRepository.findById(1)).thenReturn(Optional.of(order));

        ReturnOrder returnOrder = new ReturnOrder();
        when(returnOrderRepository.save(returnOrder)).thenReturn(returnOrder);

        //act
        ReturnOrder result = returnOrderService.saveNewReturnOrderCompletely(returnOrder, order.getOrderId());

        //assert
        assertEquals(order.getTotal(), result.getOrder().getTotal());
    }
}
