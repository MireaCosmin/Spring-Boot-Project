package com.example.proiect_final;

import com.example.proiect_final.model.*;
import com.example.proiect_final.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ProiectFinalApplication implements CommandLineRunner {


    /**
     * account - order -> one to many +
     * product - order -> many to many +
     * shop - order -> one to many +
     * shop - storage -> one to one +
     * storage - product -> many to many +
     * return order - order -> many to one
     * @param args
     */


    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private StorageRepository storageRepository;

    @Autowired
    private ShopRepository shopRepository;

    public static void main(String[] args) {
        SpringApplication.run(ProiectFinalApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        LocalDate birthDate = LocalDate.now();
        Account account1 = new Account(2000, "firstName1", "lastName1", "email1", birthDate);
        //List<Order> orderList = new ArrayList<>();
        accountRepository.save(account1);

        /*Order order1 = new Order(20);
        order1.setAccount(account1);
        orderRepository.save(order1);*/

        /*orderList.add(order1);
        account1.setOrderList(orderList);
        accountRepository.save(account1);*/

        Product product1 = new Product("Tricou", 50.0, 20);
        productRepository.save(product1);
        Product product2 = new Product("Pantaloni", 100.0, 30);
        productRepository.save(product2);

        Product product3 = new Product("Tricou", 50.0, 0);
        productRepository.save(product3);
        Product product4 = new Product("Pantaloni", 100.0, 3);
        productRepository.save(product4);
        Product product5 = new Product("Camasa", 110.0, 1);
        productRepository.save(product5);


        Storage storage1 = new Storage("Storage 1");
        List<Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);
        storage1.setStorageProductList(productList);
        storageRepository.save(storage1);

        /*List<Storage> storageList = new ArrayList<>();
        storageList.add(storage1);
        product1.setStorages(storageList);
        productRepository.save(product1);*/

        /*List<Product> productList = new ArrayList<>();
        productList.add(product1);
        storage1.setStorageProductList(productList);
        storageRepository.save(storage1);*/

        Shop shop1 = new Shop("Adresa shop 1", 1);
        shop1.setStorage(storage1);
        /*List<Order> shopOrders = new ArrayList<>();
        shopOrders.add(order1);
        shop1.setOrderList(shopOrders);*/
        shopRepository.save(shop1);

        Order order1 = new Order(20);
        order1.setAccount(account1);
        List<Product> orderProducts = new ArrayList<>();
        orderProducts.add(product3);
        order1.setOrderProductList(orderProducts);
        order1.setShop(shop1);
        orderRepository.save(order1);

    }
}
