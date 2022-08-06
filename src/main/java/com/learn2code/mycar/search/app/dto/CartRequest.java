package com.learn2code.mycar.search.app.dto;

import com.learn2code.mycar.search.app.entity.BuyerInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartRequest {
    private int modelYear;
    private String brand;
    private String model;
    private long miles;
    private double basePrice;
    private BuyerInfo buyer;
}
