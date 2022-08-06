package com.learn2code.mycar.search.app.repository;

import com.learn2code.mycar.search.app.entity.CarDetails;
import com.learn2code.mycar.search.app.repository.rowmapper.CarDetailsRowMapper;
import com.learn2code.mycar.search.app.repository.rowmapper.CarModelRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarDetailsRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<CarDetails> getAllCarsForBrandModel(int brand, int model) {
        String sql = "SELECT * FROM car_details WHERE brand_id=? AND model_id=?";
        return jdbcTemplate.query(sql,new CarDetailsRowMapper(),brand,model);
    }

    public CarDetails saveCarDetails(CarDetails carDetails) {

        String insertSql = "INSERT INTO car_details (model_year,brand_id,model_id,car_price,miles,car_location,car_deal_type,car_seller,seller_phone)" +
                " VALUES(?,?,?,?,?,?,?,?,?)";
        int result = jdbcTemplate.update(insertSql,carDetails.getModelYear(),carDetails.getBrandId(),carDetails.getModelId(),carDetails.getPrice(),carDetails.getMiles(),carDetails.getLocation(),carDetails.getDealType(),carDetails.getSeller(),carDetails.getSellerPhone());

        if(result>0){
            return jdbcTemplate.queryForObject("SELECT * FROM car_details WHERE id = (SELECT count(*) FROM car_details)", new CarDetailsRowMapper());
        }
        return null;
    }

    public CarDetails getLastCreatedCarDetails(int brand,int model) {
        String sql = "SELECT * FROM car_details WHERE brand_id=? AND model_id=? ORDER BY id DESC LIMIT 1";
        return jdbcTemplate.queryForObject(sql,new CarDetailsRowMapper(),brand,model);
    }

    public int getBrandId(String brand) {
        return jdbcTemplate.queryForObject("SELECT id FROM car_maker WHERE name=?",Integer.class,brand);
    }

    public int getModelId(String model) {
        return jdbcTemplate.queryForObject("SELECT id FROM car_model WHERE model=?",Integer.class,model);
    }
}
