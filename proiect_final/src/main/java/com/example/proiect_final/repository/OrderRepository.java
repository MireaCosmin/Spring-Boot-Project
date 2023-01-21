package com.example.proiect_final.repository;

import com.example.proiect_final.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
