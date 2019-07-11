package com.ids.isilrent.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
    private String sku;
    private String name;
    private int stock;
    private double price;
}
