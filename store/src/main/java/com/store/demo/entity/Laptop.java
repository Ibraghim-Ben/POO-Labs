package com.store.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Laptop extends Electronics {
    private String processor;
    private Integer ram;
    private Double weight;

    public Laptop() {
        super();
    }
}
