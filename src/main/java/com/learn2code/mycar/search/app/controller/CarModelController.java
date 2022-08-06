package com.learn2code.mycar.search.app.controller;

import com.learn2code.mycar.search.app.entity.CarModel;
import com.learn2code.mycar.search.app.service.CarMakerService;
import com.learn2code.mycar.search.app.service.CarModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/models")
public class CarModelController {

    @Autowired
    private CarModelService carModelService;

    @GetMapping("/{brandName}")
    public ResponseEntity<List<CarModel>> modelsForBrandByName(@PathVariable String brandName){
        List<CarModel> models = carModelService.findModelsByBrandName(brandName);
        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addModelToBrand(@RequestBody CarModel model){
        int rowsUpdated = carModelService.addNewModel(model);
        return ResponseEntity.status(HttpStatus.CREATED).body("Model :-"+model.getModelName()+" is added to brand id-"+model.getBrandId());
    }

    @PutMapping("/{modelId}")
    public ResponseEntity<CarModel> updateModel(@PathVariable int modelId, @RequestBody CarModel model){
        CarModel updatedModel = carModelService.updateModel(modelId,model);
        return ResponseEntity.ok(updatedModel);
    }

    @DeleteMapping("/{modelId}")
    public ResponseEntity<String> deleteModel(@PathVariable int modelId){
        carModelService.deleteModelById(modelId);
        return ResponseEntity.status(HttpStatus.OK).body("Model with ID-"+modelId+" deleted from DB!");
    }
}
