package com.learn2code.mycar.search.app.repository;

import com.learn2code.mycar.search.app.entity.CarModel;
import com.learn2code.mycar.search.app.repository.rowmapper.CarModelRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public class CarModelRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int createModel(CarModel model) {
        String sql = "INSERT INTO car_model(model,brand_id) VALUES(?,?)";
        return jdbcTemplate.update(sql,model.getModelName(),model.getBrandId());
    }

    public int updateCarModel(CarModel model) {
        String sql = "UPDATE car_model SET model=? AND brand_id=? WHERE id=?";
        return jdbcTemplate.update(sql,model.getModelName(),model.getBrandId(),model.getId());
    }

    public CarModel findModelById(int modelId) {
        String sql = "SELECT * FROM car_model WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new CarModelRowMapper(), modelId);
    }

    public void deleteModelById(int modelId) {
        String sql = "DELETE FROM car_model WHERE id=?";
        jdbcTemplate.update(sql,modelId);
    }

    public List<CarModel> findModelByBrandName(String brandName) {
        String sql = "SELECT * FROM car_model WHERE brand_id=(SELECT id FROM car_maker WHERE name=?)";
        List<CarModel> models = jdbcTemplate.query(sql,new CarModelRowMapper(),brandName);
        return models;
    }
}
