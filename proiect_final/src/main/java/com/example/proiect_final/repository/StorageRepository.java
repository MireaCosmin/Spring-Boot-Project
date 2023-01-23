package com.example.proiect_final.repository;

import com.example.proiect_final.model.Product;
import com.example.proiect_final.model.Storage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StorageRepository extends JpaRepository<Storage, Integer>  {

}
