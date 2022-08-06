package com.learn2code.mycar.search.app.dto;

import com.learn2code.mycar.search.app.entity.Address;
import com.learn2code.mycar.search.app.entity.Payment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckoutRequest {

    private String carDescription;
    private int quantity;
    private double basePrice;
    private double tax;
    private double totalPrice;
    private Address address;
    private Payment payment;
}
