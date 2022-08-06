package com.learn2code.mycar.search.app.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cart {
    private int id;
    private String imagePath;
    private String carDesc;
    private long miles;
    private double basePrice;
    private double taxRate;
    private double totalTax;
    private double totalPrice;
    private double dealerFee;

}
