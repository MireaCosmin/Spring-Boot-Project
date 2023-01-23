package com.example.proiect_final.service;

import com.example.proiect_final.model.Order;
import com.example.proiect_final.model.Product;
import com.example.proiect_final.model.Shop;
import com.example.proiect_final.model.Storage;
import com.example.proiect_final.repository.ProductRepository;
import com.example.proiect_final.repository.StorageRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StorageService {

    private final StorageRepository storageRepository;
    private ProductRepository productRepository;

    public StorageService(StorageRepository storageRepository, ProductRepository productRepository) {
        this.storageRepository = storageRepository;
        this.productRepository = productRepository;
    }

    public Storage saveNewStorage(Storage storage, List<Integer> storageProductId) {

        List<Product> storageProduct = productRepository.findAllById(storageProductId);

      storage.setStorageProductList(storageProduct);
        return storageRepository.save(storage);
    }

    public List<Storage> retrieveStorages() {
        return storageRepository.findAll();
    }

    public Storage addProductToStorage(Integer storageId, Integer productId) {
        Product storageProduct = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product with this id is not found"));

        System.out.println("storageProduct:"+storageProduct);
        Storage storage = storageRepository.findById(storageId)
                .orElseThrow(() -> new RuntimeException("Storage with this id is not found"));

        System.out.println("storage:"+storage);

        List<Product> storageProductsList = storage.getStorageProductList();
        storageProductsList.add(storageProduct);

        storage.setStorageProductList(storageProductsList);
        System.out.println("storage size:"+storage.getStorageProductList().size());

        return storageRepository.save(storage);


    }

    public Storage deleteStorageProduct(Integer storageId, Integer productId) {
        Storage storage = storageRepository.findById(storageId)
                .orElseThrow(() -> new RuntimeException("Storage with this id is not found"));
        List<Product> storageProductsList = storage.getStorageProductList();
        List<Product> newStorage = new ArrayList<>();
        for(Product currentProduct : storageProductsList) {
            if(currentProduct.getProductId() == productId && currentProduct.getQuantity() > 0) {
                throw new RuntimeException("Product can't be deleted");
            }
            if(currentProduct.getProductId() != productId) {
                newStorage.add(currentProduct);
            }
        }
        storage.setStorageProductList(newStorage);
        return storageRepository.save(storage);
    }

}