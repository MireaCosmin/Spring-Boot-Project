package com.example.proiect_final.repository;

import com.example.proiect_final.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer>  {

}
