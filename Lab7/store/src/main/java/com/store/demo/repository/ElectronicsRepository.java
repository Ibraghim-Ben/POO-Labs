package com.store.demo.repository;

import com.store.demo.entity.Electronics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ElectronicsRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(Electronics electronics) {
        String sql = "INSERT INTO electronics (brand, warranty_months, price, store_id) VALUES (?, ?, ?, ?)";
        this.jdbcTemplate.update(sql,
                electronics.getBrand(),
                electronics.getWarrantyMonths(),
                electronics.getPrice(),
                electronics.getStoreId()
        );
    }

    public Electronics getById(int id) {
        String sql = "SELECT * FROM electronics WHERE id = ?";
        return this.jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            Electronics electronics1 = new Electronics();
            electronics1.setId(rs.getInt("id"));
            electronics1.setBrand(rs.getString("brand"));
            electronics1.setWarrantyMonths(rs.getInt("warranty_months"));
            electronics1.setPrice(rs.getDouble("price"));
            electronics1.setStoreId(rs.getInt("store_id"));
            return electronics1;
        }, id);
    }

    public void update(Electronics electronics) {
        String sql = "UPDATE electronics SET brand = ?, warranty_months = ?, price = ?, store_id = ? WHERE id = ?";
        jdbcTemplate.update(sql,
                electronics.getBrand(),
                electronics.getWarrantyMonths(),
                electronics.getPrice(),
                electronics.getStoreId(),
                electronics.getId()
        );
    }

    public void delete(int id) {
        String sql = "DELETE FROM electronics WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
