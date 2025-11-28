package com.store.demo.controller;

import com.store.demo.entity.Store;
import com.store.demo.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/stores")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @PostMapping
    public ResponseEntity<Map<String, String>> create(@RequestBody Store store) {
        Map<String, String> map = new HashMap<>();
        try {
            storeService.create(store);

            map.put("name", store.getName());
            map.put("address", store.getAddress());
            map.put("email", store.getEmail());
            map.put("phone", store.getPhone());

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
            Store store = storeService.getById(id);

            map.put("id", store.getId().toString());
            map.put("name", store.getName());
            map.put("address", store.getAddress());
            map.put("email", store.getEmail());
            map.put("phone", store.getPhone());

            return ResponseEntity.ok(map);
        } catch (Exception e) {
            map.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStore(@PathVariable int id) {
        try {
            storeService.delete(id);
            return ResponseEntity.ok("Magazinul a fost șters cu succes");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStore(@PathVariable int id, @RequestBody Store store) {
        try {
            store.setId((long) id);
            storeService.update(store);
            return ResponseEntity.ok("Magazinul a fost actualizat cu succes");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> patchStore(@PathVariable int id, @RequestBody Map<String, Object> updates) {
        try {
            Store store = storeService.getById(id);

            if (updates.containsKey("name")) store.setName((String) updates.get("name"));
            if (updates.containsKey("address")) store.setAddress((String) updates.get("address"));
            if (updates.containsKey("email")) store.setEmail((String) updates.get("email"));
            if (updates.containsKey("phone")) store.setPhone((String) updates.get("phone"));

            storeService.update(store);
            return ResponseEntity.ok("Magazinul a fost actualizat parțial cu succes");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
