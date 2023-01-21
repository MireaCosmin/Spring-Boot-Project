package com.example.proiect_final.service;

import com.example.proiect_final.repository.StorageRepository;
import org.springframework.stereotype.Service;

@Service
public class StorageService {

    private StorageRepository storageRepository;

    public StorageService(StorageRepository storageRepository) {
        this.storageRepository = storageRepository;
    }
}
