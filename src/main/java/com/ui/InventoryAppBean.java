package com.ui;


import com.server.service.InventoryService;
import com.server.service.StoreService;
import com.server.entity.Inventory;
import com.server.entity.Store;
import com.ui.interceptor.Logged;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SessionScoped
@Named
public class InventoryAppBean implements Serializable {
    private Long id;
    private int storeId;
    private List<Store> storeList = new ArrayList<>();

    @EJB
    private Inventory inventory;

    @EJB
    private Store store;

    @EJB
    private StoreService storeService;

    @EJB
    private InventoryService inventoryService;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public List<Inventory> getInventoryList() {
        return inventoryService.getInventoryList();
    }
    public List<Store> getStoreList() {
        storeList = storeService.getStoreList();
        return storeList;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        storeService.getStoreById(storeId);
        this.storeId = storeId;
    }

    public void setInventoryService(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public void createInventory(){
        inventory.setStore(store);
        inventoryService.addInventory(inventory);
        //inventory.setAdded(Date());
        //inventory.setUpdated(Date());
        inventory = new Inventory();
    }

    @Logged
    public String addInventory() {
       Inventory inventory = new Inventory();
        Optional<Inventory> inventoryExists = inventoryService.getInventoryList().stream().filter(p ->
                p.getId().equals(id)).findFirst();
        if (inventoryExists.isPresent()) {
            inventoryService.removeInventory(inventory);
        } else {
           inventoryService.addInventory(inventory);
        }
        return "inventoryList";
    }


}
