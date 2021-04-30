package com.server.service;

import com.server.entity.Inventory;

import java.util.List;

public interface InventoryService {
    void addInventory(Inventory inventory);
    List<Inventory> getInventoryList();
    void removeInventory(Inventory inventory);
}
