package com.ids.isilrent.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Supplier {
    private String ruc;
    private String name;
    private String contactEmail;
    private String contactMobilePhone;
    private String productsku;
}
