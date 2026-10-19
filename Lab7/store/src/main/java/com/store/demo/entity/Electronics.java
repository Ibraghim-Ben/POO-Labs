package com.store.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Electronics {
    private Integer id;
    private String brand;
    private Integer warrantyMonths;
    private Double price;
    private Integer storeId;

    public Electronics() { }
}
