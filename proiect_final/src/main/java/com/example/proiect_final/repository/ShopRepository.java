package com.example.proiect_final.repository;


import com.example.proiect_final.model.Account;
import com.example.proiect_final.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop, Integer> {

}
