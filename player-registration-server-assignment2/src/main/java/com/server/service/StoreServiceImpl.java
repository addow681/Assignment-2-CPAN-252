package com.server.service;

import com.server.entity.Store;

import javax.ejb.Remote;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Remote(StoreService.class)
public class StoreServiceImpl implements StoreService{

    @PersistenceContext
    private EntityManager em;

    @Override
    public void addStore(Store store) {
em.persist(store);
    }

    @Override
    public Store getStoreById(int id) {
        Store correspondingStore = em.find(Store.class, id);
        return correspondingStore;
    }

    @Override
    public List<Store> getStoreList() {
        List<Store> storeList =  em.createNamedQuery("Store.findAll", Store.class)
                .getResultList();
        return storeList;
    }




}
