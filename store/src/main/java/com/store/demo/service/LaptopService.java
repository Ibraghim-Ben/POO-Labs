package com.store.demo.service;

import com.store.demo.entity.Laptop;

public interface LaptopService {
    void create(Laptop laptop) throws Exception;
    Laptop getById(int id) throws Exception;
}
