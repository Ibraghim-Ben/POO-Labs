package com.store.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Store {
    private Long id;
    private String name;
    private String address;
    private String email;
    private String phone;

    public Store() { }
}
