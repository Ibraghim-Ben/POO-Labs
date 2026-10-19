package com.store.demo.service.impl;

import com.store.demo.entity.Electronics;
import com.store.demo.repository.ElectronicsRepository;
import com.store.demo.service.ElectronicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ElectronicsServiceImpl implements ElectronicsService {

    @Autowired
    private ElectronicsRepository electronicsRepository;

    @Override
    public void create(Electronics electronics) throws Exception {
        if (electronics.getBrand() == null || electronics.getBrand().trim().length() < 2) {
            throw new Exception("Numele brand-ului trebuie să aibă cel puțin 2 caractere");
        }
        if (electronics.getPrice() == null || electronics.getPrice() <= 0) {
            throw new Exception("Prețul trebuie să fie mai mare decât 0");
        }
        electronicsRepository.create(electronics);
    }

    @Override
    public Electronics getById(int id) throws Exception {
        Electronics electronics = electronicsRepository.getById(id);
        if (electronics == null) {
            throw new Exception("Electronica cu id " + id + " nu a fost găsită");
        }
        return electronics;
    }

    @Override
    public void update(Electronics electronics) throws Exception {
        Electronics existing = electronicsRepository.getById(electronics.getId());
        if (existing == null) {
            throw new Exception("Electronica cu id " + electronics.getId() + " nu a fost găsită");
        }
        electronicsRepository.update(electronics);
    }

    @Override
    public void delete(int id) throws Exception {
        Electronics existing = electronicsRepository.getById(id);
        if (existing == null) {
            throw new Exception("Electronica cu id " + id + " nu a fost găsită");
        }
        electronicsRepository.delete(id);
    }
}
