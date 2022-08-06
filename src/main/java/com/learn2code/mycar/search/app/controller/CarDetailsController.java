package com.learn2code.mycar.search.app.controller;

import com.learn2code.mycar.search.app.entity.CarDetails;
import com.learn2code.mycar.search.app.service.CarDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/car-detail")
public class CarDetailsController {

    @Autowired
    private CarDetailsService carDetailsService;

    @GetMapping("/{brand}/{model}")
    public ResponseEntity<List<CarDetails>> getAllCarsOfModel(@PathVariable String brand, @PathVariable String model){
        List<CarDetails> carDetailsList = carDetailsService.findAllCars(brand,model);
        return ResponseEntity.status(HttpStatus.OK).body(carDetailsList);
    }

    @PostMapping("/{brand}/{model}")
    public ResponseEntity<CarDetails> addCarDetails(@PathVariable String brand, @PathVariable String model,@RequestBody CarDetails carDetails){
        CarDetails car = carDetailsService.saveCarDetails(brand,model,carDetails);
        return new ResponseEntity<>(car,HttpStatus.CREATED);
    }
}
