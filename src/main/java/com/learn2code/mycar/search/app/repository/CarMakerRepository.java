package com.learn2code.mycar.search.app.repository;

import com.learn2code.mycar.search.app.entity.CarMaker;
import com.learn2code.mycar.search.app.repository.rowmapper.CarMakerRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CarMakerRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<CarMaker> findAllBrands() {
        String sql = "SELECT * FROM car_maker";
        List<CarMaker> brandsList = jdbcTemplate.query(sql, new CarMakerRowMapper());
        return brandsList;
    }

    public String saveBrandName(CarMaker carMaker) {
        String sql = "INSERT INTO car_maker(name) VALUES('"+carMaker.getManufacturerName()+"')";
        int updatedRow = jdbcTemplate.update(sql);
        if(updatedRow>0){
            return "insert successful!";
        } else {
            return "error in saving car brand to DB";
        }
    }

    public CarMaker findBrandById(int id) {
        String sql ="SELECT * FROM car_maker WHERE id=?";
        return jdbcTemplate.queryForObject(sql,new CarMakerRowMapper(),id);
    }

    public void updateBrand(int id, CarMaker brand) {
        String sql = "UPDATE car_maker SET name=? WHERE id=?";
        jdbcTemplate.update(sql,brand.getManufacturerName(),id);
    }

    public void deleteBrand(int id) {
        String sql = "DELETE FROM car_maker WHERE id=?";
        jdbcTemplate.update(sql,id);
    }
}
