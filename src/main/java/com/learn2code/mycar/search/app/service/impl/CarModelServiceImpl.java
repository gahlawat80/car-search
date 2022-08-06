package com.learn2code.mycar.search.app.service.impl;

import com.learn2code.mycar.search.app.entity.CarModel;
import com.learn2code.mycar.search.app.repository.CarModelRepository;
import com.learn2code.mycar.search.app.service.CarModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CarModelServiceImpl implements CarModelService {

    @Autowired
    private CarModelRepository carModelRepository;

    @Override
    public int addNewModel(CarModel model) {
        return carModelRepository.createModel(model);
    }

    @Override
    public CarModel updateModel(int modelId, CarModel model) {
        CarModel dbModel = carModelRepository.findModelById(modelId);
        if(Objects.nonNull(model) && !"".equalsIgnoreCase(model.getModelName())){
            dbModel.setModelName(model.getModelName());
        }
        if(Objects.nonNull(model) && model.getBrandId()>0){
            dbModel.setBrandId(model.getBrandId());
        }
        carModelRepository.updateCarModel(dbModel);
        return dbModel;
    }

    @Override
    public void deleteModelById(int modelId) {
        carModelRepository.deleteModelById(modelId);
    }

    @Override
    public List<CarModel> findModelsByBrandName(String brandName) {
        return carModelRepository.findModelByBrandName(brandName);
    }
}
