package com.store.demo.service;

import com.store.demo.entity.Phone;

public interface PhoneService {
    void create(Phone phone) throws Exception;
    Phone getById(int id) throws Exception;
}
