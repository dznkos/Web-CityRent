package com.ids.isilrent.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductsSupplier {
    private String sku;
    private String pname;
    private int stock;
    private double price;
    private String ruc;
    private String sname;
    private String contactEmail;
    private String contactMobilePhone;
    private String productsku;
}
