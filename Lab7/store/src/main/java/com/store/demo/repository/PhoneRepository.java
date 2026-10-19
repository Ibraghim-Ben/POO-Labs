package com.store.demo.repository;

import com.store.demo.entity.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PhoneRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(Phone phone) {
        String sql = "INSERT INTO phone (brand, waranthy_months, price, store_id, model, os, battery, camera) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        this.jdbcTemplate.update(sql,
                phone.getBrand(),
                phone.getWarrantyMonths(),
                phone.getPrice(),
                phone.getStoreId(),
                phone.getModel(),
                phone.getOs(),
                phone.getBattery(),
                phone.getCamera()
        );
    }

    public Phone getById(int id) {
        String sql = "SELECT * FROM phone WHERE id = ?";
        return this.jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            Phone phone1 = new Phone();
            phone1.setId(rs.getInt("id"));
            phone1.setBrand(rs.getString("brand"));
            phone1.setWarrantyMonths(rs.getInt("warranty_months"));
            phone1.setPrice(rs.getDouble("price"));
            phone1.setStoreId(rs.getInt("store_id"));
            phone1.setModel(rs.getString("model"));
            phone1.setOs(rs.getString("os"));
            phone1.setBattery(rs.getInt("battery"));
            phone1.setCamera(rs.getInt("camera"));
            return phone1;
        }, id);
    }
}
