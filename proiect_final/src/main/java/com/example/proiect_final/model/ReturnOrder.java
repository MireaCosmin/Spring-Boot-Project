package com.example.proiect_final.model;

import javax.persistence.*;

@Entity
public class ReturnOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int returnOrderId;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public ReturnOrder() {
    }

    public int getReturnOrderId() {
        return returnOrderId;
    }

    public void setReturnOrderId(int returnOrderId) {
        this.returnOrderId = returnOrderId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
