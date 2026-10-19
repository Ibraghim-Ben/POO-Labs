package com.store.demo.repository;

import com.store.demo.entity.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StoreRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(Store store) {
        String sql = "INSERT INTO store (name, address, email, phone) VALUES (?, ?, ?, ?)";
        this.jdbcTemplate.update(sql,
                store.getName(),
                store.getAddress(),
                store.getEmail(),
                store.getPhone()
        );
    }

    public Store getById(int id) {
        String sql = "SELECT * FROM store WHERE id = ?";
        return this.jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            Store store1 = new Store();
            store1.setId(rs.getLong("id"));
            store1.setName(rs.getString("name"));
            store1.setAddress(rs.getString("address"));
            store1.setEmail(rs.getString("email"));
            store1.setPhone(rs.getString("phone"));
            return store1;
        }, id);
    }

    public void delete(int id) {
        String sql = "DELETE FROM store WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public void update(Store store) {
        String sql = "UPDATE store SET name = ?, address = ?, email = ?, phone = ? WHERE id = ?";
        jdbcTemplate.update(sql,
                store.getName(),
                store.getAddress(),
                store.getEmail(),
                store.getPhone(),
                store.getId()
        );
    }
}
