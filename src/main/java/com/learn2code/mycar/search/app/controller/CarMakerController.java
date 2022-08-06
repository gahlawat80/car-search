package com.learn2code.mycar.search.app.controller;

import com.learn2code.mycar.search.app.entity.CarMaker;
import com.learn2code.mycar.search.app.service.CarMakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/brands")
public class CarMakerController {
    @Autowired
    private CarMakerService carMakerService;

    @GetMapping
    public List<CarMaker> getAllCarBrands(){
        return carMakerService.getAllBrands();
    }

    @PostMapping
    public ResponseEntity<String> saveBrand(@RequestBody CarMaker carMaker){
        String result= carMakerService.saveBrand(carMaker);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarMaker> getCarBrandById(@PathVariable int id){
        CarMaker brand = carMakerService.findBrandById(id);
        return ResponseEntity.ok(brand);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarMaker> updateCarBrand(@PathVariable int id,@RequestBody CarMaker brand){
        CarMaker updatedBrand = carMakerService.updateCarBrand(id,brand);
        return ResponseEntity.status(HttpStatus.OK).body(updatedBrand);
    }

    @DeleteMapping("/{id}")
    public String deleteBrand(@PathVariable int id){
        carMakerService.deleteBrand(id);
        return "Brand is deleted with ID-"+id;
    }
}
