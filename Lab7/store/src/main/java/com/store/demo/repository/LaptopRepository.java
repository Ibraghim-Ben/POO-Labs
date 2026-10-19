package com.store.demo.repository;

import com.store.demo.entity.Laptop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LaptopRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(Laptop laptop) {
        String sql = "INSERT INTO laptop (brand, warranty_months, price, store_id, processor, ram, weight) VALUES (?, ?, ?, ?, ?, ?, ?)";
        this.jdbcTemplate.update(sql,
                laptop.getBrand(),
                laptop.getWarrantyMonths(),
                laptop.getPrice(),
                laptop.getStoreId(),
                laptop.getProcessor(),
                laptop.getRam(),
                laptop.getWeight()
        );
    }

    public Laptop getById(int id) {
        String sql = "SELECT * FROM laptop WHERE id = ?";
        return this.jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            Laptop laptop1 = new Laptop();
            laptop1.setId(rs.getInt("id"));
            laptop1.setBrand(rs.getString("brand"));
            laptop1.setWarrantyMonths(rs.getInt("warranty_months"));
            laptop1.setPrice(rs.getDouble("price"));
            laptop1.setStoreId(rs.getInt("store_id"));
            laptop1.setProcessor(rs.getString("processor"));
            laptop1.setRam(rs.getInt("ram"));
            laptop1.setWeight(rs.getDouble("weight"));
            return laptop1;
        }, id);
    }
}
