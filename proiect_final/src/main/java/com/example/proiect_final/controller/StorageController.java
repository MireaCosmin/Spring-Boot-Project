package com.example.proiect_final.controller;

import com.example.proiect_final.model.Account;
import com.example.proiect_final.model.Storage;
import com.example.proiect_final.service.StorageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("proiect")
public class StorageController {

    private final StorageService storageService;

    public StorageController(StorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping("storage/new")
    public ResponseEntity<Storage> saveStorage(@RequestBody Storage storage,
                                               @RequestParam List<Integer> productId) {
        return ResponseEntity.ok().body(storageService.saveNewStorage(storage, productId));
    }

    @GetMapping("storage/getAll")
    public ResponseEntity<List<Storage>> retrieveStorages() {
        return ResponseEntity.ok().body(storageService.retrieveStorages());
    }

    @PutMapping("storage/addProduct")
    public ResponseEntity<Storage> addProductToStorage(@RequestParam Integer storageId,
                                                       @RequestParam Integer productId) {
        return ResponseEntity.ok().body(storageService.addProductToStorage(storageId, productId));
    }

    @DeleteMapping("storage/deleteProduct")
    public ResponseEntity<Storage> deleteProductStorage(@RequestParam Integer storageId,
                                                       @RequestParam Integer productId) {
        return ResponseEntity.ok().body(storageService.deleteStorageProduct(storageId, productId));
    }
}
