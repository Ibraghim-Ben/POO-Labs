package com.store.demo.controller;

import com.store.demo.entity.Phone;
import com.store.demo.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/phones")
public class PhoneController {

    @Autowired
    private PhoneService phoneService;

    @PostMapping
    public ResponseEntity<Map<String, String>> create(@RequestBody Phone phone) {
        Map<String, String> map = new HashMap<>();
        try {
            phoneService.create(phone);

            map.put("brand", phone.getBrand());
            map.put("warrantyMonths", phone.getWarrantyMonths().toString());
            map.put("price", phone.getPrice().toString());
            map.put("storeId", phone.getStoreId().toString());
            map.put("model", phone.getModel());
            map.put("os", phone.getOs());
            map.put("battery", phone.getBattery().toString());
            map.put("camera", phone.getCamera().toString());

            return ResponseEntity.status(HttpStatus.CREATED).body(map);
        } catch (Exception e) {
            map.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(map);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, String>> getById(@PathVariable int id) {
        Map<String, String> map = new HashMap<>();
        try {
            Phone phone = phoneService.getById(id);

            map.put("id", phone.getId().toString());
            map.put("brand", phone.getBrand());
            map.put("warrantyMonths", phone.getWarrantyMonths().toString());
            map.put("price", phone.getPrice().toString());
            map.put("storeId", phone.getStoreId().toString());
            map.put("model", phone.getModel());
            map.put("os", phone.getOs());
            map.put("battery", phone.getBattery().toString());
            map.put("camera", phone.getCamera().toString());

            return ResponseEntity.ok(map);
        } catch (Exception e) {
            map.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
        }
    }
}
