package com.learn2code.mycar.search.app.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarDetails {
    private int id;
    private int modelYear;
    private int brandId;
    private int modelId;
    private double price;
    private long miles;
    private String location;
    private String dealType;
    private String seller;
    private String sellerPhone;
}
