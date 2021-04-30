package com.server.service;

import com.server.entity.Store;

import java.util.List;

public interface StoreService {
    void addStore(Store store);
    List<Store> getStoreList();
    Store getStoreById(int id);

}
