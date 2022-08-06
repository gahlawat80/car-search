package com.learn2code.mycar.search.app.service;

import com.learn2code.mycar.search.app.entity.CarModel;

import java.util.List;

public interface CarModelService {

    int addNewModel(CarModel model);

    CarModel updateModel(int modelId, CarModel model);

    void deleteModelById(int modelId);

    List<CarModel> findModelsByBrandName(String brandName);
}
