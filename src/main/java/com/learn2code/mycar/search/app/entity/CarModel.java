package com.learn2code.mycar.search.app.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarModel {
    private int id;
    private String modelName;
    private int brandId;
}
