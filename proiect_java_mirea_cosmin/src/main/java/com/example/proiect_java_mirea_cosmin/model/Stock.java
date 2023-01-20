package com.example.proiect_java_mirea_cosmin.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//@Entity
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stockId;

    /*
    @ManyToMany
    @JoinTable(name = "stock_product", joinColumns = @JoinColumn(name = "stock_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> stockProductList = new ArrayList<>();
*/
    public int getStockId() {
        return stockId;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
    }
/*
    public List<Product> getProductList() {
        return stockProductList;
    }

    public void setProductList(List<Product> productList) {
        this.stockProductList = productList;
    }
*/
    public Stock() {
    }
}
