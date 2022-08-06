package com.learn2code.mycar.search.app.service;

import com.learn2code.mycar.search.app.entity.CarMaker;

import java.util.List;

public interface CarMakerService {
    List<CarMaker> getAllBrands();

    String saveBrand(CarMaker carMaker);

    CarMaker findBrandById(int id);

    CarMaker updateCarBrand(int id, CarMaker brand);

    void deleteBrand(int id);
}
