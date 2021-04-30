package com.server.service;

import com.server.entity.Inventory;

import javax.ejb.Remote;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Remote(InventoryService.class)
public class InventoryServiceImpl implements InventoryService{

    @PersistenceContext
    private EntityManager em;

    @Override
    public void addInventory(Inventory inventory) {
em.persist(inventory);
    }

    @Override
    public List<Inventory> getInventoryList() {
        List<Inventory> inventoryList =  em.createNamedQuery("Inventory.findAll", Inventory.class)
                .getResultList();
        return inventoryList;
    }

    @Override
    public void removeInventory(Inventory inventory) {
        Inventory correspondingInventory = em.createNamedQuery("Inventory.findAll", Inventory.class)
                .getSingleResult();
        if(inventory !=null)
        em.remove(correspondingInventory);
    }

}
