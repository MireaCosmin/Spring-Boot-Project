package com.example.proiect_java_mirea_cosmin;

import com.example.proiect_java_mirea_cosmin.model.Account;
import com.example.proiect_java_mirea_cosmin.model.Product;
import com.example.proiect_java_mirea_cosmin.model.Stock;
import com.example.proiect_java_mirea_cosmin.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class ProiectJavaMireaCosminApplication implements CommandLineRunner {

    /**
     * account - order -> one to many +
     * product - order -> many to many +
     * shop - order -> one to many +
     * shop - stock -> one to one +
     * stock - product -> many to many +
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
    private ReturnOrderRepository returnOrderRepository;
    @Autowired
    private ShopRepository shopRepository;
    @Autowired
    private StockRepository stockRepository;


    public static void main(String[] args) {
        SpringApplication.run(ProiectJavaMireaCosminApplication.class, args);
    }

    @Override
    public void run(String...args) throws Exception {
/*
        LocalDate joinDate = LocalDate.now();
        LocalDate birthdate = LocalDate.of(1999, 4, 17);
        Account account1 = new Account(20, "joinDate", "birtDate");
        accountRepository.save(account1);

        Product product1 = new Product("Papuci", 20.00);
        productRepository.save(product1);

        Stock stock1 = new Stock();
        List<Product> productList = new ArrayList<>();
        productList.add(product1);
        stock1.setProductList(productList);
        stockRepository.save(stock1);
*/
    }

}
