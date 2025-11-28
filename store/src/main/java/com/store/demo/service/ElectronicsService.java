package com.store.demo.service;

import com.store.demo.entity.Electronics;

public interface ElectronicsService {
    void create(Electronics electronics) throws Exception;
    Electronics getById(int id) throws Exception;
    void update(Electronics electronics) throws Exception;
    void delete(int id) throws Exception;
}
