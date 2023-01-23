package com.example.proiect_final.controller;

import com.example.proiect_final.model.Account;
import com.example.proiect_final.model.Order;
import com.example.proiect_final.service.AccountService;
import com.example.proiect_final.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("proiect")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("order/new")
    public ResponseEntity<Order> saveOrder(@RequestBody Order order,
                                            @RequestParam Integer accountId,
                                            @RequestParam Integer shopId,
                                            @RequestParam List<Integer> productIdList) {
        return ResponseEntity.ok().body(orderService.saveNewOrder(order, accountId, shopId, productIdList));
    }

    @GetMapping("order/getAll")
    public ResponseEntity<List<Order>> retrieveOrders() {
        return ResponseEntity.ok().body(orderService.retrieveOrders());
    }
}
