package com.store.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Phone extends Electronics {
    private String model;
    private String os;
    private Integer battery;
    private Integer camera;

    public Phone() {
        super();
    }
}
