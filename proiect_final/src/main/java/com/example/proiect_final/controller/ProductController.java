package com.example.proiect_final.controller;

import com.example.proiect_final.model.Account;
import com.example.proiect_final.model.Product;
import com.example.proiect_final.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("proiect")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("product/new")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        return ResponseEntity.ok().body(productService.saveNewProduct(product));
    }

    @GetMapping("product/getAll")
    public ResponseEntity<List<Product>> retrieveAccounts() {
        return ResponseEntity.ok().body(productService.retrieveProducts());
    }
}
