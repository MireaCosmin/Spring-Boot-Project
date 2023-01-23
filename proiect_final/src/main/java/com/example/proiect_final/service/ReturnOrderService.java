package com.example.proiect_final.service;

import com.example.proiect_final.model.Order;
import com.example.proiect_final.model.Product;
import com.example.proiect_final.model.ReturnOrder;
import com.example.proiect_final.repository.OrderRepository;
import com.example.proiect_final.repository.ReturnOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReturnOrderService {

    private ReturnOrderRepository returnOrderRepository;
    private OrderRepository orderRepository;

    public ReturnOrderService(ReturnOrderRepository returnOrderRepository,
                              OrderRepository orderRepository) {
        this.returnOrderRepository = returnOrderRepository;
        this.orderRepository = orderRepository;
    }

    public ReturnOrder saveNewReturnOrderCompletely(ReturnOrder returnOrder, Integer orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order Not found"));
        //refund the money
        Double accountBalance = order.getAccount().getBalance();
        Double orderTotalTax = order.getTotal();
        order.getAccount().setBalance(accountBalance + orderTotalTax);
        //increase the stock
        List<Product> orderedProductsList = order.getOrderProductList();
        List<Product> storedProductsList = order.getShop().getStorage().getStorageProductList();
        for(Product orderProduct : orderedProductsList) {
            for(Product storedProduct : storedProductsList) {
                if(orderProduct.getName().equals(storedProduct.getName())) {
                    Integer currentQuantity = storedProduct.getQuantity();
                    storedProduct.setQuantity(currentQuantity + orderProduct.getQuantity());
                }
            }
        }
        returnOrder.setOrder(order);
        return returnOrderRepository.save(returnOrder);
    }
}
