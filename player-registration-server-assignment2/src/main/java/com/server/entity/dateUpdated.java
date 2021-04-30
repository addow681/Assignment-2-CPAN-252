package com.server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class dateUpdated { //Updates inventory data
    private Long id;
    private String name;
    private String sport;
    private int quantity;
    private double pricePerUnit;
    private Date added;
    private Date updated;
}
