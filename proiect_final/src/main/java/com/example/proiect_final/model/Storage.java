package com.example.proiect_final.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Storage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int storageId;

    private String storageName;

    public Storage(String storageName) {
        this.storageName = storageName;
    }

    public String getStorageName() {
        return storageName;
    }

    public void setStorageName(String storageName) {
        this.storageName = storageName;
    }

    public int getStorageId() {
        return storageId;
    }

    public void setStorageId(int storageId) {
        this.storageId = storageId;
    }

    @ManyToMany
    @JoinTable(name = "storage_product", joinColumns = @JoinColumn(name = "storage_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> storageProductList = new ArrayList<>();

    public List<Product> getStorageProductList() {
        return storageProductList;
    }

    public void setStorageProductList(List<Product> storageProductList) {
        this.storageProductList = storageProductList;
    }

    public Storage() {
    }


}
