package com.learn2code.mycar.search.app.service.impl;

import com.learn2code.mycar.search.app.entity.CarMaker;
import com.learn2code.mycar.search.app.repository.CarMakerRepository;
import com.learn2code.mycar.search.app.service.CarMakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CarMakerServiceImpl implements CarMakerService {
    @Autowired
    private CarMakerRepository carMakerRepository;

    @Override
    public List<CarMaker> getAllBrands() {
        return carMakerRepository.findAllBrands();
    }

    @Override
    public String saveBrand(CarMaker carMaker) {
        return carMakerRepository.saveBrandName(carMaker);
    }

    @Override
    public CarMaker findBrandById(int id) {
        return carMakerRepository.findBrandById(id);
    }

    @Override
    public CarMaker updateCarBrand(int id, CarMaker brand) {
        CarMaker dbBrand = carMakerRepository.findBrandById(id);
        if(Objects.nonNull(brand) && !"".equalsIgnoreCase(brand.getManufacturerName())){
            carMakerRepository.updateBrand(id,brand);
        }
        return brand;
    }

    @Override
    public void deleteBrand(int id) {
        carMakerRepository.deleteBrand(id);
    }
}
