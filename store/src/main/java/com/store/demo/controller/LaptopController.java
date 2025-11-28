package com.store.demo.controller;

import com.store.demo.entity.Laptop;
import com.store.demo.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/laptops")
public class LaptopController {

    @Autowired
    private LaptopService laptopService;

    @PostMapping
    public ResponseEntity<Map<String, String>> create(@RequestBody Laptop laptop) {
        Map<String, String> map = new HashMap<>();
        try {
            laptopService.create(laptop);

            map.put("brand", laptop.getBrand());
            map.put("warrantyMonths", laptop.getWarrantyMonths().toString());
            map.put("price", laptop.getPrice().toString());
            map.put("storeId", laptop.getStoreId().toString());
            map.put("processor", laptop.getProcessor());
            map.put("ram", laptop.getRam().toString());
            map.put("weight", laptop.getWeight().toString());

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
            Laptop laptop = laptopService.getById(id);

            map.put("id", laptop.getId().toString());
            map.put("brand", laptop.getBrand());
            map.put("warrantyMonths", laptop.getWarrantyMonths().toString());
            map.put("price", laptop.getPrice().toString());
            map.put("storeId", laptop.getStoreId().toString());
            map.put("processor", laptop.getProcessor());
            map.put("ram", laptop.getRam().toString());
            map.put("weight", laptop.getWeight().toString());

            return ResponseEntity.ok(map);
        } catch (Exception e) {
            map.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
        }
    }
}
