package com.store.demo.controller;

import com.store.demo.entity.Electronics;
import com.store.demo.service.ElectronicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/electronics")
public class ElectronicsController {

    @Autowired
    private ElectronicsService electronicsService;

    @PostMapping
    public ResponseEntity<Map<String, String>> create(@RequestBody Electronics electronics) {
        Map<String, String> map = new HashMap<>();
        try {
            electronicsService.create(electronics);

            map.put("brand", electronics.getBrand());
            map.put("warrantyMonths", electronics.getWarrantyMonths().toString());
            map.put("price", electronics.getPrice().toString());
            map.put("storeId", electronics.getStoreId().toString());

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
            Electronics electronics = electronicsService.getById(id);

            map.put("id", electronics.getId().toString());
            map.put("brand", electronics.getBrand());
            map.put("warrantyMonths", electronics.getWarrantyMonths().toString());
            map.put("price", electronics.getPrice().toString());
            map.put("storeId", electronics.getStoreId().toString());

            return ResponseEntity.ok(map);
        } catch (Exception e) {
            map.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateElectronics(@PathVariable int id, @RequestBody Electronics electronics) {
        try {
            electronics.setId(id);
            electronicsService.update(electronics);
            return ResponseEntity.ok("Electronica a fost actualizată cu succes");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> patchElectronics(@PathVariable int id, @RequestBody Map<String, Object> updates) {
        try {
            Electronics electronics = electronicsService.getById(id);

            if (updates.containsKey("brand")) electronics.setBrand((String) updates.get("brand"));
            if (updates.containsKey("warrantyMonths")) electronics.setWarrantyMonths((Integer) updates.get("warrantyMonths"));
            if (updates.containsKey("price")) electronics.setPrice(Double.valueOf(updates.get("price").toString()));
            if (updates.containsKey("storeId")) electronics.setStoreId((Integer) updates.get("storeId"));

            electronicsService.update(electronics);
            return ResponseEntity.ok("Electronica a fost actualizată parțial cu succes");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteElectronics(@PathVariable int id) {
        try {
            electronicsService.delete(id);
            return ResponseEntity.ok("Electronica a fost ștearsă cu succes");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
