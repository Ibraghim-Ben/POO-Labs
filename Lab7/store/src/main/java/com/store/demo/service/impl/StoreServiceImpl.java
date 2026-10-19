package com.store.demo.service.impl;

import com.store.demo.entity.Store;
import com.store.demo.repository.StoreRepository;
import com.store.demo.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreRepository storeRepository;

    @Override
    public void create(Store store) throws Exception {
        if (store.getName() == null || store.getName().trim().length() < 3) {
            throw new Exception("Numele magazinului trebuie să aibă cel puțin 3 caractere");
        }
        if (store.getEmail() == null || !store.getEmail().contains("@")) {
            throw new Exception("Email-ul magazinului nu este valid");
        }
        storeRepository.create(store);
    }

    @Override
    public Store getById(int id) throws Exception {
        Store store = storeRepository.getById(id);
        if (store == null) {
            throw new Exception("Magazinul cu id " + id + " nu a fost găsit");
        }
        return store;
    }

    @Override
    public void delete(int id) throws Exception {
        Store store = storeRepository.getById(id);
        if (store == null) {
            throw new Exception("Magazinul cu id " + id + " nu a fost găsit");
        }
        storeRepository.delete(id);
    }

    @Override
    public void update(Store store) throws Exception {
        Store existing = storeRepository.getById(store.getId().intValue());

        if (store.getName() == null || store.getName().trim().length() < 3) {
            throw new Exception("Numele magazinului trebuie să aibă cel puțin 3 caractere");
        }
        if (store.getEmail() == null || !store.getEmail().contains("@")) {
            throw new Exception("Email-ul magazinului nu este valid");
        }

        storeRepository.update(store);
    }

}
