package com.store.demo.service.impl;

import com.store.demo.entity.Laptop;
import com.store.demo.repository.LaptopRepository;
import com.store.demo.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaptopServiceImpl implements LaptopService {

    @Autowired
    private LaptopRepository laptopRepository;

    @Override
    public void create(Laptop laptop) throws Exception {
        if (laptop.getProcessor() == null || laptop.getProcessor().trim().length() < 3) {
            throw new Exception("Numele procesorului trebuie să aibă cel puțin 3 caractere");
        }
        if (laptop.getRam() == null || laptop.getRam() <= 1) {
            throw new Exception("Memoria RAM trebuie să fie mai mare decât 1");
        }
        laptopRepository.create(laptop);
    }

    @Override
    public Laptop getById(int id) throws Exception {
        Laptop laptop = laptopRepository.getById(id);
        if (laptop == null) {
            throw new Exception("Laptop-ul cu id " + id + " nu a fost găsit");
        }
        return laptop;
    }
}
