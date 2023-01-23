package com.example.proiect_final.service;

import com.example.proiect_final.exceptions.InsufficientBalanceError;
import com.example.proiect_final.exceptions.InsufficientStockError;
import com.example.proiect_final.exceptions.InvalidUserAge;
import com.example.proiect_final.exceptions.ProductNotFoundError;
import com.example.proiect_final.model.Account;
import com.example.proiect_final.model.Order;
import com.example.proiect_final.model.Product;
import com.example.proiect_final.model.Shop;
import com.example.proiect_final.repository.AccountRepository;
import com.example.proiect_final.repository.OrderRepository;
import com.example.proiect_final.repository.ProductRepository;
import com.example.proiect_final.repository.ShopRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private OrderRepository orderRepository;
    private ProductRepository productRepository;
    private AccountRepository accountRepository;
    private ShopRepository shopRepository;

    public OrderService(OrderRepository orderRepository,ProductRepository productRepository, AccountRepository accountRepository,ShopRepository shopRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.accountRepository = accountRepository;
        this.shopRepository = shopRepository;
    }

    public Order saveNewOrder(Order order, Integer accoundId, Integer shopId, List<Integer> productIdList) {
        List<Product> productList = productRepository.findAllById(productIdList);
        Account account = accountRepository.findById(accoundId)
                .orElseThrow(() -> new RuntimeException("Account with this id is not found!"));
        Shop shop = shopRepository.findById(shopId)
                .orElseThrow(() -> new RuntimeException("Shop with this id is not found!"));
        order.setOrderProductList(productList);
        order.setAccount(account);
        order.setShop(shop);
        Double total = 0.0;
        for(Product product : productList) {
            total = total + product.getPrice() * product.getQuantity();
        }

        //check if we are eligible for discount
        if(total > 200) {
            //apply discount
            Double discount = 0.2 * total;
            total = total - discount;
            order.setDiscount(discount);
        }
        order.setTotal(total);

        //check if we have enough balance
        if(account.getBalance() < total) {
            throw new InsufficientBalanceError("Insufficient balance");
        }

        //check if the shop has enough stock
        List<Product> storageProductsList = shop.getStorage().getStorageProductList();

        Boolean productFound;
        for(Product orderedProduct : productList) {
            productFound = false;
            for(Product storageProduct : storageProductsList) {
                if(orderedProduct.getName().equals(storageProduct.getName()) ) {
                    productFound = true;
                    if(orderedProduct.getQuantity() > storageProduct.getQuantity()) {
                        throw new InsufficientStockError("Insufficient stock");
                    }
                }

            }
            if(productFound == false) {
                throw new ProductNotFoundError("Product not found");
            }
        }


        //reduce account balance
        Double accountBalance = account.getBalance();
        account.setBalance(accountBalance - total);

        return orderRepository.save(order);
    }

    public List<Order> retrieveOrders() {
        return orderRepository.findAll();
    }

}
