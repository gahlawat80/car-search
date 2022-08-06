package com.learn2code.mycar.search.app.service;

import com.learn2code.mycar.search.app.entity.CarDetails;

import java.util.List;

public interface CarDetailsService {
    List<CarDetails> findAllCars(String brand, String model);

    CarDetails saveCarDetails(String brand, String model, CarDetails carDetails);
}
