package com.learn2code.mycar.search.app.service.impl;

import com.learn2code.mycar.search.app.entity.CarDetails;
import com.learn2code.mycar.search.app.repository.CarDetailsRepository;
import com.learn2code.mycar.search.app.service.CarDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CarDetailsServiceImpl implements CarDetailsService {

    @Autowired
    private CarDetailsRepository carDetailsRepository;

    @Override
    public List<CarDetails> findAllCars(String brand, String model) {
        int brandId=0;
        int modelId=0;
        if(Objects.nonNull(brand) && !"".equalsIgnoreCase(brand)){
            brandId = carDetailsRepository.getBrandId(brand);
        }
        if(Objects.nonNull(model) && !"".equalsIgnoreCase(model)){
            modelId=carDetailsRepository.getModelId(model);
        }
        List<CarDetails> cars = carDetailsRepository.getAllCarsForBrandModel(brandId,modelId);
        return cars;
    }

    @Override
    public CarDetails saveCarDetails(String brand, String model, CarDetails carDetails) {
        int brandId=0;
        int modelId=0;
        if(Objects.nonNull(brand) && !"".equalsIgnoreCase(brand)){
            brandId = carDetailsRepository.getBrandId(brand);
            carDetails.setBrandId(brandId);
        }
        if(Objects.nonNull(model) && !"".equalsIgnoreCase(model)){
            modelId=carDetailsRepository.getModelId(model);
            carDetails.setModelId(modelId);
        }
        carDetailsRepository.saveCarDetails(carDetails);

        return carDetailsRepository.getLastCreatedCarDetails(brandId,modelId);
    }
}
