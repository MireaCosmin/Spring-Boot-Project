package com.example.proiect_final.service;

import com.example.proiect_final.model.Product;
import com.example.proiect_final.model.Shop;
import com.example.proiect_final.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product saveNewProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> retrieveProducts() {
        return productRepository.findAll();
    }
}
