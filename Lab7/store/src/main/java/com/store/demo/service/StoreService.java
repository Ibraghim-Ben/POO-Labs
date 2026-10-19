package com.store.demo.service;

import com.store.demo.entity.Store;

public interface StoreService {
    void create(Store store) throws Exception;
    Store getById(int id) throws Exception;
    void delete(int id) throws Exception;
    void update(Store store) throws Exception;
}