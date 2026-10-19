package com.store.demo.service.impl;

import com.store.demo.entity.Phone;
import com.store.demo.repository.PhoneRepository;
import com.store.demo.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhoneServiceImpl implements PhoneService {

    @Autowired
    private PhoneRepository phoneRepository;

    @Override
    public void create(Phone phone) throws Exception {
        if (phone.getModel() == null || phone.getModel().trim().length() < 2) {
            throw new Exception("Modelul telefonului trebuie să aibă cel puțin 2 caractere");
        }
        if (phone.getBattery() == null || phone.getBattery() <= 0) {
            throw new Exception("Bateria trebuie să fie mai mare decât 0");
        }
        phoneRepository.create(phone);
    }

    @Override
    public Phone getById(int id) throws Exception {
        Phone phone = phoneRepository.getById(id);
        if (phone == null) {
            throw new Exception("Telefonul cu id " + id + " nu a fost găsit");
        }
        return phone;
    }
}
